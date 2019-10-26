package com.zhku.mh.quartz_demo.config.config;

import com.zhku.mh.quartz_demo.config.MySecondJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

@Configuration
public class QuartzConfig {

    /*
    * 这种配置JobDetail的方法，只需要指定Job的实例名和要调用的方法即可
    * 这种方式无法在创建JobDetail时传递参数
    */
    @Bean
    MethodInvokingJobDetailFactoryBean jobDetail() {
        MethodInvokingJobDetailFactoryBean bean =
                new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myFirstJob");
        bean.setTargetMethod("sayHello");
        return bean;
    }

    /*
    * 第二种注入JobDetail的方法
    * 这种只需指定JobDetail时传递参数即可，
    * 然后，通过JobDataMap传递参数到Job中
    * Job只需要提供一个相应的set方法，就可以接受到参数
    */
    @Bean
    JobDetailFactoryBean jobDetail2() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MySecondJob.class);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name", "mh");
        bean.setJobDataMap(jobDataMap);
        bean.setDurability(true);
        return bean;
    }

    /*
    *  首先设置JobDetail
    */
    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean() {
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(jobDetail().getObject());
        bean.setRepeatCount(3); //任务循环次数
        bean.setStartDelay(2000); //配置任务的启动延迟时间   延迟第一次执行的
        bean.setRepeatInterval(2000); //设置任务的时间间隔
        return bean;
    }

    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(jobDetail2().getObject());
        bean.setCronExpression("* * * * * ?");
        return bean;
    }

    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        SimpleTrigger simpleTrigger = simpleTriggerFactoryBean().getObject();
        CronTrigger cronTrigger = cronTriggerFactoryBean().getObject();
        bean.setTriggers(simpleTrigger, cronTrigger);
        return bean;
    }
}

package com.zhku.mh.schedule_demo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class configMyConfig {

    /**
     * 当前任务结束1s后开启另一个任务
     */
    @Scheduled(fixedDelay = 2000)
    public void fixedDelay() {
        System.out.println("1" + new Date());
    }

    /**
     * 当前任务开始后2s后开启另一个计时任务
     */
    @Scheduled(fixedRate = 2000)
    public void fixedRate() {
        System.out.println("2" + new Date());
    }

    /**
     * initialDelay 延迟1s执行
     * fixedRate 当前任务开始后2s后开启另一个计时任务
     */
//    @Scheduled(initialDelay = 2000, fixedRate = 2000)
    public void initialDelay() {
        System.out.println("3" + new Date());
    }

//    @Scheduled(cron = "0 */3 * * * ?")
    public void cron() {
        System.out.println("4" + new Date());
    }

}

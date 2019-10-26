package com.zhku.mh.activemq_demp.confiig;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class BeanConfig {

    @Bean
    Queue queue(){
        return new ActiveMQQueue("amq");
    }
}

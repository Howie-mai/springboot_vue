package com.zhku.mh.activemq_demp.controller;

import com.zhku.mh.activemq_demp.entities.Message;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueConsumeController {

//    @JmsListener(destination = "active.queue")
//    public void readActiveQueue(String message) {
//        System.out.println("接收到：" + message);
//    }
    @JmsListener(destination = "amq")
    public void readActiveQueue(Message message) {
        System.out.println("接收到：" + message);
    }
}

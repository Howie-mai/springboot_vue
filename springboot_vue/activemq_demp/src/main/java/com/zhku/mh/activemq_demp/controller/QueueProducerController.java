package com.zhku.mh.activemq_demp.controller;

import com.zhku.mh.activemq_demp.component.JmsComponent;
import com.zhku.mh.activemq_demp.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class QueueProducerController {
    @Autowired
    JmsComponent jmsComponent;

    @RequestMapping("/sendQueue")
    public Message sendQueue(){
        Message msg = new Message();
        msg.setContent("hello xiaoyuyu");
        msg.setDate(new Date());
        jmsComponent.send(msg);
        return msg;
    }
}

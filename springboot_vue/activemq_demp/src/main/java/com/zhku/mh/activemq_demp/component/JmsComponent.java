package com.zhku.mh.activemq_demp.component;

import com.zhku.mh.activemq_demp.entities.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class JmsComponent {
    @Autowired
    JmsMessagingTemplate messagingTemplate;
    @Autowired
    Queue queue;
    public void send(Message msg) {
        messagingTemplate.convertAndSend(queue, msg);
    }
}

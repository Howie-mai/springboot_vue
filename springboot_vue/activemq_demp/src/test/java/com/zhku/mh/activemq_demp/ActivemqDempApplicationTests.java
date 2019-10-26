package com.zhku.mh.activemq_demp;

import com.zhku.mh.activemq_demp.component.JmsComponent;
import com.zhku.mh.activemq_demp.entities.Message;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
class ActivemqDempApplicationTests {
    @Autowired
    JmsComponent jmsComponent;

    @Test
    void contextLoads() {
        Message msg = new Message();
        msg.setContent("hello xiaoyuyu");
        msg.setDate(new Date());
        jmsComponent.send(msg);
    }
}

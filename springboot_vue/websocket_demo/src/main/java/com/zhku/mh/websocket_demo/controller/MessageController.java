package com.zhku.mh.websocket_demo.controller;

import com.zhku.mh.websocket_demo.entities.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.FormatStyle;
import java.util.Date;

@Controller
public class MessageController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Message greeting(Message message) throws Exception{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        message.setTime(df.format(new Date()));
        return message;
    }
}

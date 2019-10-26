package com.zhku.mh.websocket_demo.controller;

import com.zhku.mh.websocket_demo.entities.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class GreetingController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @GetMapping("/index")
    public ModelAndView index(Principal principal){
        ModelAndView mav = new ModelAndView();
        mav.addObject("username",principal.getName());
        mav.setViewName("onlinechat");
        return mav;
    }

    @MessageMapping("/chat")
    public void chat(Principal principal, Chat chat){
        String from = principal.getName();
        chat.setFrom(from);
        messagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
    }
}

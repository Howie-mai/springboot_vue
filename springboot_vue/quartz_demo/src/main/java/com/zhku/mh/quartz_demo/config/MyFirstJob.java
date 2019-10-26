package com.zhku.mh.quartz_demo.config;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyFirstJob {
    public void sayHello(){
        System.out.println("MyFirstJob：hello world"+new Date());
    }
}

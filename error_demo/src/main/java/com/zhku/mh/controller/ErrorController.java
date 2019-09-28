package com.zhku.mh.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @RequestMapping("error5")
    public String Error5xx(){
        int i = 1/0;
        return "hello";
    }
}

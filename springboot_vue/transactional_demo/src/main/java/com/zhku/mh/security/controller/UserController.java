package com.zhku.mh.security.controller;

import com.zhku.mh.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    public Integer save(String name,String pwd){
        return userService.insertUser(name,pwd);
    }
}

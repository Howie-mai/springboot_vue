package com.zhku.mh.controller;

import com.zhku.mh.po.User;
import com.zhku.mh.po.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    Users users;

    @RequestMapping("/users")
    public ModelAndView users(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("users",users);
        mav.setViewName("users");
        return mav;
    }

    @ResponseBody
    @RequestMapping("/list")
    public Users usersList(){
        return users;
    }
}

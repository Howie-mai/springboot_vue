package com.zhku.mh.validation_demo.controller;

import com.zhku.mh.validation_demo.entities.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @PostMapping("/save")
    public Object save(@Validated @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
        List<String> errors = new ArrayList<>();
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError data:allErrors) {
                errors.add(data.getDefaultMessage());
            }
        return errors;
        }
        return user;
    }
}

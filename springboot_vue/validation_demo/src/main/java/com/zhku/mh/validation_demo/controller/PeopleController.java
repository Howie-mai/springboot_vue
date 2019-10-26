package com.zhku.mh.validation_demo.controller;

import com.zhku.mh.validation_demo.ValidateGroup.ValidationGroup2;
import com.zhku.mh.validation_demo.entities.People;
import com.zhku.mh.validation_demo.entities.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PeopleController {

    @PostMapping("/create")
    public Object save(@Validated(ValidationGroup2.class) @RequestBody People people, BindingResult result){
        if(result.hasErrors()){
            List<String> errors = new ArrayList<>();
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError data:allErrors) {
                errors.add(data.getDefaultMessage());
            }
            return errors;
        }
        return people;
    }
}

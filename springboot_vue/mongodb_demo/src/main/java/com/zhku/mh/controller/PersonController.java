package com.zhku.mh.controller;

import com.zhku.mh.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/get3")
    public void get3(){
        Person person = new Person();
        person.setId(1);
        person.setName("张三");
        mongoTemplate.insert(person);

        List<Person> list = mongoTemplate.findAll(Person.class);
        System.out.println(list);
    }
}

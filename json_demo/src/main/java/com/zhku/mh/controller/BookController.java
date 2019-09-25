package com.zhku.mh.controller;

import com.zhku.mh.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class BookController {
    @Autowired
    Book book;

    @RequestMapping("/book")
    public Book book(){
        return book;
    }

    @RequestMapping("/book1")
    public Book book1(){
        Book book1 = new Book();
        book1.setName("java");
        book1.setAuthor("石玉强");
        book1.setPrice(59f);
        book1.setPulishTime(new Date());
        return book1;
    }

    @RequestMapping("/book2")
    public Book book2(@RequestBody  Book book2){
        System.out.println(book2);
        return book2;
    }
}

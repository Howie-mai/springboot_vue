package com.zhku.mh.controller;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.zhku.mh.entities.Book;
import com.zhku.mh.entities.FastJsonBook;
import com.zhku.mh.entities.GsonBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class BookController {


    @RequestMapping("/book")
    public Book book1(){
        Book book1 = new Book();
        book1.setName("java");
        book1.setAuthor("石玉强");
        book1.setPrice(59f);
        book1.setPulishTime(new Date());
        return book1;
    }

    @RequestMapping("/gsonBook")
    public GsonBook gsonBook(){
        GsonBook gsonBook = new GsonBook();
        gsonBook.setName("C");
        gsonBook.setAuthor("石玉强");
        gsonBook.setPrice(59f);
        gsonBook.setPulishTime(new Date());
        return gsonBook;
    }

    @RequestMapping("/jsonBook")
    public FastJsonBook jsonBook(){
        FastJsonBook jsonBook = new FastJsonBook();
        jsonBook.setPrice(59f);
        jsonBook.setPulishTime(new Date());
        return jsonBook;
    }

    @RequestMapping("/book2")
    public FastJsonBook book2(@RequestBody FastJsonBook book2){
        return book2;
    }
}

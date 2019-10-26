package com.zhku.mh.security.controller;

import com.zhku.mh.security.dao.BookDao;
import com.zhku.mh.security.entities.Book;
import com.zhku.mh.security.entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookDao bookDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/get1")
    public void get1(){
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(1);
        book1.setName("springboot_mongodb");
        book1.setAuthor("wangsong");
        books.add(book1);
        Book book2 = new Book();
        book2.setId(2);
        book2.setName("java");
        book2.setAuthor("wang作者不详");
        books.add(book2);
        bookDao.insert(books);
        List<Book> dataList = bookDao.findByAuthorContains("wang");
        System.out.println(dataList);
        Book book = bookDao.findByNameEquals("java");
        System.out.println(book);
    }

    @GetMapping("/get2")
    public void get2(){
        List<Book> books1 = new ArrayList<>();
        Book book1 = new Book();
        book1.setId(3);
        book1.setName("围城");
        book1.setAuthor("钱钟书");
        books1.add(book1);
        Book book2 = new Book();
        book2.setId(4);
        book2.setName("宋诗选注");
        book2.setAuthor("钱钟书");
        books1.add(book2);
        mongoTemplate.insertAll(books1);
        List<Book> dataList = mongoTemplate.findAll(Book.class);
        System.out.println(dataList);
        List<Book> dataList2 = mongoTemplate.findAll(Book.class,"person");
        System.out.println(dataList2);
        Book book = mongoTemplate.findById(3,Book.class);
        System.out.println(book);
        Book bk = mongoTemplate.findById(3,Book.class,"person");
        System.out.println(bk);
    }

    @RequestMapping("/get4")
    public void get4(){
        List<Book> dataList = mongoTemplate.findAll(Book.class);
        System.out.println(dataList);
        List<Person> dataList2 = mongoTemplate.findAll(Person.class,"person");
        System.out.println(dataList2);
        Book book = mongoTemplate.findById(3,Book.class);
        System.out.println(book);
        Person p = mongoTemplate.findById(3,Person.class,"person");
        System.out.println(p);
    }
}

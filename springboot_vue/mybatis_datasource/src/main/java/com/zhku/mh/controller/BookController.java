package com.zhku.mh.controller;

import com.zhku.mh.dao.mapper1.Book1Mapper;
import com.zhku.mh.dao.mapper2.Book2Mapper;
import com.zhku.mh.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private Book1Mapper book1Mapper;
    @Autowired
    private Book2Mapper book2Mapper;

    @RequestMapping("/save")
    public void save(){
        Book book = new Book();
        book.setName("springboot");
        book.setAuthor("王松");
        book1Mapper.insertBook(book);

        book.setName("C");
        book.setAuthor("作者不详");
        book2Mapper.insertBook(book);
    }
}

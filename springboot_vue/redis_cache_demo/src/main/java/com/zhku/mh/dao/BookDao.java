package com.zhku.mh.dao;

import com.zhku.mh.entities.Book;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class BookDao {
    @Cacheable("c1")
    public Book getBookById(Integer id) {
        System.out.println("getBookById");
        Book book = new Book();
        book.setId(id);
        book.setName("java");
        book.setAuthor("作者不详");
        return book;
    }
}

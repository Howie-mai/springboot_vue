package com.zhku.mh.security.dao;

import com.zhku.mh.security.entities.Book;
import com.zhku.mh.utils.MyKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "book_cache")
public class BookDao {
    @Autowired
    MyKeyGenerator myKeyGenerator;
 //   @Cacheable(keyGenerator = "myKeyGenerator")
    @Cacheable(key = "#id")
    public Book getBookById(Integer id) {
        System.out.println("getBookById");
        Book book = new Book();
        book.setId(id);
        book.setName("三国演义");
        book.setAuthor("罗贯中");
        return book;
    }
    @CachePut(key = "#book.id")
    public Book updateBookById(Book book) {
        System.out.println("updateBookById");
        book.setName("三国演义2");
        return book;
    }
    @CacheEvict(key = "#id")
    public void deleteBookById(Integer id) {
        System.out.println("deleteBookById");
    }
}

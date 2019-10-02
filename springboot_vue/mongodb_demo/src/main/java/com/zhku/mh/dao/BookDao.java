package com.zhku.mh.dao;

import com.zhku.mh.entities.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookDao extends MongoRepository<Book,Integer> {
    List<Book> findByAuthorContains(String author);
    Book findByNameEquals(String name);
}

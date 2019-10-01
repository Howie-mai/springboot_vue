package com.zhku.mh.controller;

import com.zhku.mh.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/save")
    public void test1(){
        ValueOperations<String,String> ops1 = stringRedisTemplate.opsForValue();
        ops1.set("name","springboot_redis");
        String name = ops1.get("name");
        System.out.println(name);

        ValueOperations ops2 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setName("springboot123");
        book.setAuthor("wangsong");
        book.setId(1);
        ops2.set("book",book);
        Book book1 = (Book) ops2.get("book");
        System.out.println(book1);
    }
}

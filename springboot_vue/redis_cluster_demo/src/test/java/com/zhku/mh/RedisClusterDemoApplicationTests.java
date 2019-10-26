package com.zhku.mh;

import com.zhku.mh.security.dao.BookDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClusterDemoApplicationTests {
    @Autowired
    BookDao bookDao;
    @Test
    public void contextLoads() {
        bookDao.getBookById(100);
        String book = bookDao.getBookById(100);
        System.out.println(book);
        bookDao.updateBookById(100);
        String book2 = bookDao.getBookById(100);
        System.out.println(book2);
        bookDao.deleteById(100);
        bookDao.getBookById(100);
        bookDao.getBookById2(100);
    }

    @Test
    public void delete() {
        bookDao.deleteById(100);
    }
}

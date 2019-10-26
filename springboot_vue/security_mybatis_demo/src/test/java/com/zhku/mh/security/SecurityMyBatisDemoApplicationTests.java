package com.zhku.mh.security;

import com.zhku.mh.security.dao.UserMapper;
import com.zhku.mh.security.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@MapperScan("com.zhku.mh.security.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityMyBatisDemoApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        User user = userMapper.loadUserByUsername("admin");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encodedPassword = passwordEncoder.encode(user.getPassword().trim());
        user.setPassword(encodedPassword);

        System.out.println(user);
    }

}

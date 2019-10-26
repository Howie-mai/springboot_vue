package com.zhku.mh.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhku.mh.security.dao")
@SpringBootApplication
public class SecurityMybatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityMybatisDemoApplication.class, args);
    }

}

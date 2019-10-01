package com.zhku.mh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@MapperScan("com.zhku.mh.mapper")
@SpringBootApplication
public class TransactionalDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionalDemoApplication.class, args);
    }

}

package com.zhku.mh.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @PostMapping("/save")
    public String saveBook(String name) {
        return "recevice:" + name;
    }

    @DeleteMapping("/del/{id}")
    public String DeleteBook(@PathVariable Long id) {
        return String.valueOf(id);
    }
}

package com.zhku.mh.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/admin/hello")
    public String admin() {
        return "hello admin";
    }
    @GetMapping("/db/hello")
    public String dba() {
        return "hello dba";
    }
    @GetMapping("/user/hello")
    public String user() {
        return "hello user";
    }
    @GetMapping("/mh/hello")
    public String mh() {
        return "hello mh";
    }
}

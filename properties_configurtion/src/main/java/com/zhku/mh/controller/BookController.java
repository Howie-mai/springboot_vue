package com.zhku.mh.controller;

import com.zhku.mh.po.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    Book book;

    @RequestMapping("/book")
    public ModelAndView getBook(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("book",book);
        mav.setViewName("book");
        return mav;
    }
}

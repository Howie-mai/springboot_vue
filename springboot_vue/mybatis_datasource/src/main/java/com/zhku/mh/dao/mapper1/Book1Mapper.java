package com.zhku.mh.dao.mapper1;

import com.zhku.mh.entities.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Book1Mapper {
    Integer insertBook(Book book);
}

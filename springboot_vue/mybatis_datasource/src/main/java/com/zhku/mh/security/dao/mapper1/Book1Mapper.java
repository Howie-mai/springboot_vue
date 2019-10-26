package com.zhku.mh.security.dao.mapper1;

import com.zhku.mh.security.entities.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Book1Mapper {
    Integer insertBook(Book book);
}

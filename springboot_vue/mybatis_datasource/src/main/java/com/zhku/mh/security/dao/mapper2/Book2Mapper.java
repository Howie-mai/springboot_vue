package com.zhku.mh.security.dao.mapper2;

import com.zhku.mh.security.entities.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Book2Mapper {
    Integer insertBook(Book book);
}

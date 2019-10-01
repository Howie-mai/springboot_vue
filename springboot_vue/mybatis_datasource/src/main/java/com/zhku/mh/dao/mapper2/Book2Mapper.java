package com.zhku.mh.dao.mapper2;

import com.zhku.mh.entities.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Book2Mapper {
    Integer insertBook(Book book);
}

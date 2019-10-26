package com.zhku.mh.security.dao;

import com.zhku.mh.security.entities.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface MenuMapper {
    List<Menu> getAllMenus();
}

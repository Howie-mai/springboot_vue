package com.zhku.mh.security.dao;

import com.zhku.mh.security.entities.Role;
import com.zhku.mh.security.entities.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User loadUserByUsername(@Param("username") String username);

    List<Role> getUserRolesById(@Param("id") Integer id);

}

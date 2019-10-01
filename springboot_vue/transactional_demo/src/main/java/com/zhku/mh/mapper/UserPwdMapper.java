package com.zhku.mh.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserPwdMapper {
    Integer insertUserPwd(@Param("pwd") String pwd);
}

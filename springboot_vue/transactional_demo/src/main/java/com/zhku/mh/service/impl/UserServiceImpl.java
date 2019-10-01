package com.zhku.mh.service.impl;

import com.zhku.mh.entities.UserPwd;
import com.zhku.mh.mapper.UserMapper;
import com.zhku.mh.mapper.UserPwdMapper;
import com.zhku.mh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPwdMapper userPwdMapper;

    @Override
    public Integer insertUser(String name,String pwd) {
        userMapper.insertUser(name);
        userPwdMapper.insertUserPwd(pwd);
        return 1;
    }
}

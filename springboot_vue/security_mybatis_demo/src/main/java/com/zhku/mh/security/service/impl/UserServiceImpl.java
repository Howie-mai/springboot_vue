package com.zhku.mh.security.service.impl;

import com.zhku.mh.security.dao.UserMapper;
import com.zhku.mh.security.entities.User;
import com.zhku.mh.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if(user == null){
            throw  new UsernameNotFoundException("账户不存在！");
        }
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
//        String encodedPassword = passwordEncoder.encode(user.getPassword().trim());
//        user.setPassword(encodedPassword);
        user.setRoles(userMapper.getUserRolesById(user.getId()));
        return user;
    }
}

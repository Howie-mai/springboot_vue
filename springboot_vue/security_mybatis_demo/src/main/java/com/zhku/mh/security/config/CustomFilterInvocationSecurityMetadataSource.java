package com.zhku.mh.security.config;

import com.zhku.mh.security.dao.MenuMapper;
import com.zhku.mh.security.entities.Menu;
import com.zhku.mh.security.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomFilterInvocationSecurityMetadataSource
        implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> allMenus = menuMapper.getAllMenus();
        for (Menu menu:allMenus) {
            //获取当前请求的URL所需要的角色信息并返回
            if(antPathMatcher.match(menu.getPattern(),requestUrl)){
                List<Role> roles = menu.getRoles();
                String[] roleAttr = new String[roles.size()];
                for(int i=0;i < roleAttr.length;i++){
                    roleAttr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(roleAttr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}

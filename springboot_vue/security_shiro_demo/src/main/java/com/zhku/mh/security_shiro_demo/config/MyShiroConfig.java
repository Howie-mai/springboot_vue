package com.zhku.mh.security_shiro_demo.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.TextConfigurationRealm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.servlet.ShiroFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyShiroConfig {

    @Bean
    public Realm realm(){
        TextConfigurationRealm realm = new TextConfigurationRealm();
        realm.setUserDefinitions("mh=123456,user\n admin=123456,admin");
        realm.setRoleDefinitions("admin=read,write\n user=read");
        return realm;
    }
    //配置基本过滤信息
    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition chainDefinition =
                new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/login","anon");
        chainDefinition.addPathDefinition("/doLogin","anon");
        chainDefinition.addPathDefinition("/logout","logout");
        chainDefinition.addPathDefinition("/**","authc"); //需要认证后才能访问
        return chainDefinition;
    }

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }
}

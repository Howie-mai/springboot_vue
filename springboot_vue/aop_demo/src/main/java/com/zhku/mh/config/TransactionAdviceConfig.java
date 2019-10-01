package com.zhku.mh.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;

@Aspect
@Component
public class TransactionAdviceConfig {
    @Pointcut("execution(* com.zhku.mh.service.impl.*.*(..))")
    public void pc(){}
}

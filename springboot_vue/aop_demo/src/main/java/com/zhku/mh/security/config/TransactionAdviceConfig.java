package com.zhku.mh.security.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAdviceConfig {
    @Pointcut("execution(* com.zhku.mh.security.service.impl.*.*(..))")
    public void pc(){}
}

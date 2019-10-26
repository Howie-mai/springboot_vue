package com.zhku.mh.security.config;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Log4j2
public class LogAspect {
    @Pointcut("execution(* com.zhku.mh.mapper.*.*(..))")
    public void pc1(){}

    @Around("pc1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        long begin = System.nanoTime();
        Object obj = joinPoint.proceed();
        long end = System.nanoTime();

        log.info("调用Mapper方法：{}，参数：{}，执行耗时：{}纳秒，耗时：{}毫秒",
                joinPoint.getSignature().toString(), Arrays.toString(joinPoint.getArgs()),
                (end - begin), (end - begin) / 1000000);
        return obj;
    }
}

package com.zff.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

/**
 * 用于记录日志的工具类，提供公共的代码
 *
 */
@Component
@Aspect
public class Logger {
    @Pointcut("execution(* com.zff.service.Impl.*.*(..))")
    private void  pt1(){}
    // 前置通知
    @Before(" pt1()")
    public void beforePrintLog(){
        System.out.println("前置通知beforePrintLog...");
    }

    // 后置通知
    @AfterReturning(" pt1()")
    public void afterReturningPrintLog(){
        System.out.println("后置通知afterReturningPrintLog...");
    }
    // 异常通知
    @AfterThrowing(" pt1()")
    public void afterThrowingPrintLog(){
        System.out.println("异常通知afterThrowingPrintLog...");
    }
    // 最终通知
    @After(" pt1()")
    public void afterPrintLog(){
        System.out.println("最终通知afterPrintLog...");
    }
    // 环绕通知
    @Around( "pt1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            System.out.println("前置通知");
            Object[] args = pjp.getArgs();
            rtValue = pjp.proceed(args);
            System.out.println("后置通知");
            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("最终通知");
        }
        return rtValue;
    }

}

package com.zff.utils;

import org.aspectj.lang.ProceedingJoinPoint;

import java.util.concurrent.TimeoutException;

/**
 * 用于记录日志的工具类，提供公共的代码
 *
 */
public class Logger {
    // 前置通知
    public void beforePrintLog(){
        System.out.println("前置通知beforePrintLog...");
    }

    // 后置通知
    public void afterReturningPrintLog(){
        System.out.println("后置通知afterReturningPrintLog...");
    }
    // 异常通知
    public void afterThrowingPrintLog(){
        System.out.println("异常通知afterThrowingPrintLog...");
    }
    // 最终通知
    public void afterPrintLog(){
        System.out.println("最终通知afterPrintLog...");
    }
    // 环绕通知
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

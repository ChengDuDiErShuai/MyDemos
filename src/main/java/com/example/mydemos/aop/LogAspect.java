package com.example.mydemos.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : huangjie121015
 * @date : 2021/11/11 13:56
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.example.mydemos.controller..*(..))")
    public void controllerPointcut() {
    }

//    @Before("controllerPointcut()")
//    public void beforeExecute(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        System.out.println("before中的方法名：" + name);
//        System.out.println("before...");
//    }
//
//    @After("controllerPointcut()")
//    public void afterExecute(JoinPoint joinPoint) {
//        String name = joinPoint.getSignature().getName();
//        System.out.println("after中的方法名：" + name);
//        System.out.println("after...");
//    }

    @AfterReturning(value = "controllerPointcut()", returning = "result")
    public void AfterReturningExecute(JoinPoint joinPoint, Object result) {
        System.out.println("AfterReturning...");
        String name = joinPoint.getSignature().getName();
        System.out.println("方法" + name + "的返回值是" + result);
    }

//    @Around("controllerPointcut()")
//    public Object aruondExecute(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("around before...");
//        String name = joinPoint.getSignature().getName();
//        Object o = joinPoint.proceed();
//        System.out.println("方法" + name + "的返回值是" + o);
//        System.out.println("around after...");
//        return o;
//    }
}

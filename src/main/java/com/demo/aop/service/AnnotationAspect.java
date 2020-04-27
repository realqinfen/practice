package com.demo.aop.service;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {

    //定义一个通用的切点，供通知方法使用
    @Pointcut("execution(* com.demo.aop.service.UserService.*(..))")
    public void aspect() {
    }

    //如果没有指定公用的切点或者需要单独指定切点，可以使用表达式指定
    @Before("execution(* com.demo.aop.service.UserService.sayHello(..)) && args(name)")
//    @Before("aspect()&&args(name)")
    public void before(String name) {
        System.out.println("前置通知 " + name);
    }

    @Around("execution(* com.demo.aop.service.UserService.sayHi(..)) && args(name)")
//    @Around("aspect() && args(joinpoint,name)")
    public void around(ProceedingJoinPoint joinpoint, String name) {
        System.out.println("环绕通知 " + name);
        try {
            joinpoint.proceed();//将控制权交给被通知的方法，也就是执行sayHello()方法
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}

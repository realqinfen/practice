package com.demo.aop.service;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello,"+name);
    }

    @Override
    public void sayHi(String name) {
        System.out.println("hi,"+name);
    }
}

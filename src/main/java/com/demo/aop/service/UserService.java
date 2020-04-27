package com.demo.aop.service;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;

public interface UserService {
    void sayHello(String name);

    void sayHi(String name);

}

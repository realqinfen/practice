package com.demo.aop.service;

import com.demo.aop.model.Member;
import lombok.Data;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

/**
 * xml版Aspect切面bean
 */
@Data
public class XmlAspect {


    //配置前置通知，使用在方法aspect()注册的切入点，同时可以接收JoinPoint切入点对象，也可以没有参数
    public void before(String name, int age) {
        System.out.println("before " + name + " " + age);
    }

    //配置后置通知，使用在aspect()方法上注册的切入点
    public void after(Joinpoint joinpoint, Member member) {
        System.out.println("after ");
    }

    //配置环绕通知
    public void around(Joinpoint joinpoint, String name) {
        long start = System.currentTimeMillis();
        try {
            joinpoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("around " + joinpoint + " " + name + "\t use time:" + (end - start) + "ms!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    //配置后置通知返回
    public void afterReturn(Joinpoint joinpoint) {
        System.out.println("afterReturn " + joinpoint);
    }

    //抛出异常后的通知
    public void afterThrow(Joinpoint joinpoint, Exception ex) {
        System.out.println("after throw " + joinpoint + "\t" + ex.getMessage());
    }
}

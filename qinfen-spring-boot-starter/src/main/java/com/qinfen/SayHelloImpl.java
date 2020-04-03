package com.qinfen;

import org.springframework.beans.factory.annotation.Autowired;

public class SayHelloImpl implements SayHello {
    @Autowired
    private QfProperties qfProperties;

    @Override
    public void say() {
        String name = qfProperties.getName();
        System.out.println(name + "，你好！我是秦奋");
    }
}

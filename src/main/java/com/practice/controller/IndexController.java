package com.practice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/index")
public class IndexController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        System.out.println("hello world");
        return "hello world";
    }

}

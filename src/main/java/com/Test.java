package com;

import com.demo.aop.model.Member;
import com.demo.aop.service.MemberService;
import com.demo.aop.service.MemberServiceImpl;
import com.demo.aop.service.UserService;
import org.aopalliance.intercept.Joinpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.AccessibleObject;

public class Test {
    public static void main(String[] args) {


        /*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application-aop.xml");
        MemberService memberService = (MemberService) ctx.getBean("memberService");
        memberService.getMember("qinfen",33);
        memberService.saveMember(new Joinpoint() {
            @Override
            public Object proceed() throws Throwable {
                return null;
            }

            @Override
            public Object getThis() {
                return null;
            }

            @Override
            public AccessibleObject getStaticPart() {
                return null;
            }
        }, "qinfen");*/
    }
}

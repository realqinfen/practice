package demo.aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Test {
    @Autowired
    TestSayService sayService;

    @PostConstruct
    public void init(){
        sayService.saying("hello spring boot aop");
    }
}

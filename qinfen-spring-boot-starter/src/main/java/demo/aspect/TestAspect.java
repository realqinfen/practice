package demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    public TestAspect(){
        System.out.println("创建TestAspect成功");
    }
    //定义切点
    @Pointcut("execution(* *.saying(..))")
    public void say(){}

    //环绕通知
    @Around("say()")
    public void sayAround(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知开始");
        pjp.proceed();//执行方法
        System.out.println("环绕通知结束");
    }

    @Before("say()")
    public void sayBefore(JoinPoint joinPoint){
        System.out.println("sayBefore");
        System.out.println("获取连接点方法运行时的入参列表:"+joinPoint.getArgs());
        System.out.println("获取连接点的方法签名对象:"+joinPoint.getSignature());
        System.out.println("获取连接点所在的目标对象:"+joinPoint.getTarget());
    }

    @After("say()")
    public void sayAfter(JoinPoint joinPoint){
        System.out.println("sayAfter");
    }
}

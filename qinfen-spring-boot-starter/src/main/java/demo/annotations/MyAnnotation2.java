package demo.annotations;

import demo.enums.StatusEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface MyAnnotation2 {
    StatusEnum status() default StatusEnum.GOOD;

    boolean boo() default false;

    Class<?> cla() default Void.class;

    MyAnnotation1 anno() default @MyAnnotation1(val = 1);

    String[] arr();
}

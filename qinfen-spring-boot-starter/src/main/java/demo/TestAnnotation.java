package demo;

import demo.annotations.MyAnnotation1;
import demo.annotations.MyAnnotation2;
import demo.enums.StatusEnum;

@MyAnnotation2(status = StatusEnum.BAD,
        boo = true,cla = String.class,
        anno = @MyAnnotation1(val =1),
        arr = {"a","b"})
public class TestAnnotation {
}

package demo.reflect;

public class A {
    public static void main(String[] args) {
        if ("B".equals(args[0])) {
            B b = new B();
        }
        if ("C".equals(args[0])) {
            C c = new C();
        }
    }
}

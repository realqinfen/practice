package demo.Proxy.dynamicProxy;

import demo.Proxy.staticProxy.Greeting;
import demo.Proxy.staticProxy.GreetingImpl;

public class JDKClient {
    public static void main(String[] args) {
        Greeting greeting = new JDKDynamicProxy(new GreetingImpl()).getProxy();
        greeting.sayHello("hello");
    }
}

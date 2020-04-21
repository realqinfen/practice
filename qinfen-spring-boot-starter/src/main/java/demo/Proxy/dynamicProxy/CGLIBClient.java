package demo.Proxy.dynamicProxy;

import demo.Proxy.staticProxy.Greeting;
import demo.Proxy.staticProxy.GreetingImpl;

public class CGLIBClient {
    public static void main(String[] args) {
        Greeting greeting = CGLIBDynamicProxy.getInstance().getProxy(GreetingImpl.class);
        greeting.sayHello("qinfen");
    }
}

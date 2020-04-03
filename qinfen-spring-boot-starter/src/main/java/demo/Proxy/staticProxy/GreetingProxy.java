package demo.Proxy.staticProxy;

import demo.Proxy.staticProxy.Greeting;
import demo.Proxy.staticProxy.GreetingImpl;

public class GreetingProxy implements Greeting {
    private GreetingImpl greetingImpl;

    public GreetingProxy(GreetingImpl greetingImpl) {
        this.greetingImpl = greetingImpl;
    }

    @Override
    public void sayHello(String name) {
        before();
        greetingImpl.sayHello("qinfen");
        after();
    }

    private void before(){}
    private void after(){}
}

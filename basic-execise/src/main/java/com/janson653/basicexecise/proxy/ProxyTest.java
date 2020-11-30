package com.janson653.basicexecise.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        TargetService target = new TargetServiceImpl();

        LogHandler handler = new LogHandler(target);
        TargetService proxy = (TargetService) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        proxy.sayHello();
        System.out.println(proxy.getClass());


    }
}

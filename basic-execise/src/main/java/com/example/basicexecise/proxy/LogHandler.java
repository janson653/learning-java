package com.example.basicexecise.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {
    Object myProxy;

    public LogHandler(Object proxy) {
        this.myProxy = proxy;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("log start");
        Object result = method.invoke(myProxy, args);
        System.out.println("log end");
        return result;
    }
}

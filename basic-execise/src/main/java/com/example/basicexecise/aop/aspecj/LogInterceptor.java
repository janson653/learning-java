package com.example.basicexecise.aop.aspecj;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptor {

    @Before("execution(public void com.example.basicexecise.aop.aspecj.UserService.sayHello())")
    public void before() {
        System.out.println("开始调用sayHello");
    }

    @After("execution(public void com.example.basicexecise.aop.aspecj.UserService.sayHello())")
    public void after() {
        System.out.println("结束调用sayHello");
    }


}

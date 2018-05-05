package com.example.javadesignpattern.dp.strategy;

public class Strategy1 implements IStrategy {
    @Override
    public void doSomething() {
        System.out.println("执行策略1");
    }
}

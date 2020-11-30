package com.janson653.designpattern.dp.command;

public class ConcreteReceiver1 extends Receiver {
    @Override
    public void doSomething() {
        System.out.println("ConcreteReceiver1 doSomething");
    }
}

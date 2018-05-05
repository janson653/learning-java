package com.example.javadesignpattern.dp.state;

public class ConcreteState2 extends State {
    @Override
    public void handle1() {
        super.context.setCurrentState(Context.concreteState1);
        super.context.handle1();
    }

    @Override
    public void handle2() {
        System.out.println("ConcreteState2 handle2");
    }
}

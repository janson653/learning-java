package com.janson653.designpattern.dp.state;

public class ConcreteState1 extends State {
    @Override
    public void handle1() {
        System.out.println("ConcreteState1 handle1");
    }

    @Override
    public void handle2() {
        super.context.setCurrentState(Context.concreteState2);
        super.context.handle2();
    }
}

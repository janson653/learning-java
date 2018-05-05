package com.example.javadesignpattern.dp.state;

public class Context {
    private State state;
    public final static State concreteState1 = new ConcreteState1();
    public final static State concreteState2 = new ConcreteState2();

    public void setCurrentState(State state) {
        this.state = state;
        // set
        this.state.setContext(this);
    }

    public void handle1() {
        this.state.handle1();
    }

    public void handle2() {
        this.state.handle2();
    }

}

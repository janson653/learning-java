package com.example.javadesignpattern.dp.decorator;

public class StrongBehavior extends Decorator {
    public StrongBehavior(Swan swan) {
        super(swan);
    }

    @Override
    public void fly() {
        System.out.println("begin to Fly");
    }
}

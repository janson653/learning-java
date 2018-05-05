package com.example.javadesignpattern.dp.decorator;

public class UglyDuckling implements Swan {

    @Override
    public void fly() {
        System.out.println("too young, cannot fly");
    }

    @Override
    public void cry() {
        System.out.println("呱呱呱");
    }

    @Override
    public void desAppaearance() {
        System.out.println("外貌丑丑的");
    }
}

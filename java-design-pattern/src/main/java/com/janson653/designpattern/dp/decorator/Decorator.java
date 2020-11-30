package com.janson653.designpattern.dp.decorator;

public class Decorator implements Swan{
    Swan swan;

    public Decorator(Swan swan) {
        this.swan = swan;
    }


    @Override
    public void fly() {
        swan.fly();
    }

    @Override
    public void cry() {
        swan.cry();
    }

    @Override
    public void desAppaearance() {
        swan.desAppaearance();
    }
}

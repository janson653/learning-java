package com.janson653.designpattern.dp.strategy;

public class StrategyContext {
    IStrategy strategy;

    public StrategyContext(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void runStrategy() {
        this.strategy.doSomething();
    }
}

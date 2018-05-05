package com.example.javadesignpattern.dp.strategy;

public class Client {
    public static void main(String[] args) {
        // could be replace
        IStrategy strategy = new Strategy2();

        StrategyContext strategyContext = new StrategyContext(strategy);
        strategyContext.runStrategy();
    }
}

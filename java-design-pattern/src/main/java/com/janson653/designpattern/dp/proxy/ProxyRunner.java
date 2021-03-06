package com.janson653.designpattern.dp.proxy;

public class ProxyRunner implements Runner{
    Runner runner;

    public ProxyRunner(Runner runner) {
        this.runner = runner;
    }


    @Override
    public void run() {
        System.out.println("ProxyRunner doSomething");
        runner.run();
    }
}

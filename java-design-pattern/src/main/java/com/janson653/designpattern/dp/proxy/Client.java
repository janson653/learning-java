package com.janson653.designpattern.dp.proxy;

public class Client {
    public static void main(String[] args) {
        Runner realRunner = new RealRunner();
        Runner proxyRunner = new ProxyRunner(realRunner);
        proxyRunner.run();
    }
}

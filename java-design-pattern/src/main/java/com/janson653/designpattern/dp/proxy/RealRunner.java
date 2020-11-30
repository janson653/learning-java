package com.janson653.designpattern.dp.proxy;

public class RealRunner implements Runner {
    @Override
    public void run() {
        System.out.println("RealRunner run ....");
    }
}

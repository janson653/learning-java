package com.example.javadesignpattern.dp.proxy;

public class RealRunner implements Runner {
    @Override
    public void run() {
        System.out.println("RealRunner run ....");
    }
}

package com.example.javadesignpattern.dp.singleton;

public class Singleton2 {
    // volatile 是用来保证可见行的
    private static volatile Singleton2 instance;

    private Singleton2() {

    }

    public static Singleton2 getInstance () {
        if (instance == null) {
            synchronized (instance) {
                if(instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}

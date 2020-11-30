package com.janson653.designpattern.dp.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        int maxTestCount = 1000;
        EnumSingleton singleton = EnumSingleton.getInstance();
        singleton.doSomething();
        EnumSingleton.getInstance().doSomething();
        for(int i = 0; i < maxTestCount; i++) {
            new Thread(()-> {
                System.out.println(singleton == EnumSingleton.getInstance());
            }).start();
        }

    }
}

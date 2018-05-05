package com.example.javadesignpattern.dp.singleton;

public class EnumSingleton {
    private EnumSingleton() {

    }
    public static EnumSingleton getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public void doSomething() {
        System.out.println("doSomething");
    }

    enum Singleton {
        INSTANCE;
        private EnumSingleton singleton;

        private Singleton() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }

    }

}

package com.janson653.myspring.anatation;

@MyComponent("people")
public class People {
    private String name;
    private String age;

    public People() {
        name = "zhangqian";
        age = "28";
    }

    public void doSomething() {
        System.out.println("我是" + name + ", 今年" + age);
    }
}

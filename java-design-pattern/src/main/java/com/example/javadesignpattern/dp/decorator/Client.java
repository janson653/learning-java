package com.example.javadesignpattern.dp.decorator;

public class Client {
    public static void main(String[] args) {
        System.out.println("开始讲故事,从前有一只丑小鸭");
        Swan uglyDuckling = new UglyDuckling();
        // 展示丑小鸭的特征
        uglyDuckling.desAppaearance();
        uglyDuckling.cry();
        uglyDuckling.fly();

        // 丑小鸭长大了
        System.out.println("丑小鸭长大了");
        uglyDuckling = new BeautifyAppearance(uglyDuckling);
        uglyDuckling = new StrongBehavior(uglyDuckling);
        uglyDuckling.desAppaearance();
        uglyDuckling.cry();
        uglyDuckling.fly();
    }
}

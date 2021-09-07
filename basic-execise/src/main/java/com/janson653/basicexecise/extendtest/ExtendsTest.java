package com.janson653.basicexecise.extendtest;

/**
 * @author zhangqian
 * @date 2021/8/31
 */
public class ExtendsTest {
    public static void main(String[] args) {
        // 结论，隐藏父类的字段

        // case3
        Father xxx = new Son();
        System.out.println(xxx);
        System.out.println(xxx.name);
        System.out.println(xxx.age);

        Son son = (Son) xxx;
        System.out.println(son);
        System.out.println(son.name);
        System.out.println(son.age);
    }
}

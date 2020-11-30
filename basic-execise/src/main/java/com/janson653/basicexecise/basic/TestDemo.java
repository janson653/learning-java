package com.janson653.basicexecise.basic;
/**
 * 测试上界，下届通配符
 * */
class Message<T> {
    private T info;

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Message<CharSequence> msg = new Message<>();
        msg.setInfo("111");
        print(msg);
    }
    public static void print(Message<? super CharSequence> tmp) {
        System.out.println(tmp.getInfo());
    }
}

package com.janson653.basicexecise.thread;

import lombok.SneakyThrows;

/**
 * @author zhangqian
 * @date 2021/6/8
 */
public class ThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (ThreadTest.class) {

                }
            }
        });
        System.err.println(thread.getState());
        synchronized (ThreadTest.class) {
            thread.start();
            System.err.println(thread.getState());

            while (true) {
                System.err.println(thread.getState());
            }
        }



    }
}

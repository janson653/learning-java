package com.janson653.basicexecise.basic;

import java.util.concurrent.CountDownLatch;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 100000000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.err.println("done");
        latch.await();
    }
}

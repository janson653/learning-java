package com.janson653.basicexecise.thread.queue;

/**
 * @author zhangqian
 * @date 2021/6/17
 */
public class ThreadCreateTest {
    public static void main(String[] args) {

        for(int i = 0; i < 100_0000; i ++) {
            int finalI = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("你好" + finalI);
                }
            });
            t.start();
        }
    }
}

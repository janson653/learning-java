package com.janson653.basicexecise.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhangqian
 * @date 2021/6/2
 */
public class MyThreadPoolTest {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(4, new ArrayBlockingQueue<>(20), 1);

        Thread.currentThread().setName("主线程");

        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            myThreadPool.execute(() -> {
                System.out.println("线程" + Thread.currentThread().getName() + "执行任务" + finalI);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        myThreadPool.shutdown();
    }
}

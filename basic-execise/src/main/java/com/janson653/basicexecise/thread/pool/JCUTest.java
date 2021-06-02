package com.janson653.basicexecise.thread.pool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangqian
 * @date 2021/6/2
 */
public class JCUTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue<>(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        Thread.currentThread().setName("main-thread");

        for(int i= 1; i < 10; i++) {
            threadPool.execute(() -> {
                System.out.println("你好，线程" + Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        threadPool.shutdown();
    }
}

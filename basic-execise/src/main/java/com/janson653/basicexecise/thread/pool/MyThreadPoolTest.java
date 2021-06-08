package com.janson653.basicexecise.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author zhangqian
 * @date 2021/6/2
 */
public class MyThreadPoolTest {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.err.println("线程【" + t.getName() + "】发生异常，原因:" + e.getMessage());
            }
        });
        MyThreadPool myThreadPool = new MyThreadPool(4, new ArrayBlockingQueue<>(20), 2);

        Thread.currentThread().setName("主线程");

        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            myThreadPool.execute(() -> {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() + "执行任务" + finalI);
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        myThreadPool.shutdown();
    }
}

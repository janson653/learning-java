package com.janson653.basicexecise.thread;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangqian
 * @date 2021/6/25
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 15, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), new ThreadPoolExecutor.DiscardPolicy());

        for(int i = 1; i < 100_0000; i++) {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Objects.requireNonNull(null);
                }
            });
        }


        System.out.println("状态：" + poolExecutor.isShutdown());
        System.out.println("状态：" + poolExecutor.toString());
    }
}

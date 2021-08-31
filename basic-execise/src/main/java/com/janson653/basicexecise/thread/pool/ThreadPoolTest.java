package com.janson653.basicexecise.thread.pool;

import org.springframework.util.StopWatch;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangqian
 * @date 2021/6/8
 */
public class ThreadPoolTest {
    static AtomicInteger eventId = new AtomicInteger(1);
    static int TOTAL_EVENT_NUM = 50;

    static ThreadPoolExecutor IO_TASK_POOL = new ThreadPoolExecutor(10240, 10240, 0, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        CountDownLatch latch = new CountDownLatch(TOTAL_EVENT_NUM);

        for(int i=0; i < TOTAL_EVENT_NUM; i++) {
            IO_TASK_POOL.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finally {
                        latch.countDown();
                    }
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        System.err.println("cost=" + stopWatch.getTotalTimeMillis());
    }
}

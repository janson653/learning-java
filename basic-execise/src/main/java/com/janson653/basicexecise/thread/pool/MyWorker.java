package com.janson653.basicexecise.thread.pool;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangqian
 * @date 2021/6/2
 */
public class MyWorker extends Thread {
    private volatile boolean running = false;

    private Runnable firstTask;

    private MyThreadPool myThreadPool;

    public MyWorker(Runnable firstTask, MyThreadPool myThreadPool) {
        this.firstTask = firstTask;
        this.myThreadPool = myThreadPool;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try {
            this.running = true;
            runRealTask();
        } finally {
            this.running = false;
        }
    }

    private void runRealTask() {
        // 第一次任务通过构造器闯进来
        if (firstTask != null) {
            firstTask.run();
            firstTask = null;
        }

        // 后面的任务通过队列获取
        while (true) {
            Runnable task = myThreadPool.getTask();
            if (task != null) {
                task.run();
            }
        }
    }
}

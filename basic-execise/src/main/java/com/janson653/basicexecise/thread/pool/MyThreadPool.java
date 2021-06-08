package com.janson653.basicexecise.thread.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;

/**
 * @author zhangqian
 * @date 2021/6/2
 */
public class MyThreadPool {
    private int coreSize;
    private BlockingQueue<Runnable> taskQueue;

    // 1丢弃，2拒绝，3.调用线程执行
    private int rejectPolicy = 1;


    private volatile int workerSize = 0;
    private List<MyWorker> workers;

    // 1初始化，2运行，3停止
    private int state;

    public MyThreadPool(int coreSize, BlockingQueue<Runnable> blockingQueue, int rejectPolicy) {
        if (coreSize <= 0) {
            throw new RuntimeException("coreSize must not be 0");
        }

        Objects.requireNonNull(blockingQueue, "blockingQueue must not be nulll");

        this.coreSize = coreSize;
        this.taskQueue = blockingQueue;
        this.rejectPolicy = rejectPolicy;
        workers = new ArrayList<>(coreSize);
    }

    /**
     * 执行任务
     */
    public void execute(Runnable command) {
        if (command == null) {
            throw new NullPointerException();
        }

        // todo 检查thread是否空闲
        if (workerSize < coreSize) {
            addAndRunWorker(command);
            return;
        }

        try {
//            System.out.println("工作线程已满，任务加到队列");
            taskQueue.add(command);
        } catch (Exception ex) {
            if (rejectPolicy == 2) {
                throw new RuntimeException("队列已满，拒绝接收任务");
            } else if (rejectPolicy == 3) {
                command.run();
            } else {
                System.out.println("队列已满，执行丢弃策略，丢掉任务");
            }
        }
    }

    public void shutdown() {
        this.state = 3;

        for(MyWorker worker: workers) {
            if (!worker.isInterrupted()) {
                worker.interrupt();
            }
        }
    }

    private void addAndRunWorker(Runnable command) {
        MyWorker myWorker = new MyWorker(command, this);
        myWorker.start();
        workers.add(myWorker);
        workerSize++;
    }

    public Runnable getTask() {
//        return taskQueue.poll();
        try {
            return taskQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

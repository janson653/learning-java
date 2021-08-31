package com.janson653.basicexecise.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitSignalExample {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void before2() {
        synchronized (AwaitSignalExample.class) {
            System.out.println("before");
            condition.signalAll();
        }
    }

    public void after2() {
        synchronized (AwaitSignalExample.class) {
//            try {
//                condition.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("after");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        AwaitSignalExample example = new AwaitSignalExample();
        executorService.execute(() -> example.after2());
        executorService.execute(() -> example.before2());

        executorService.shutdown();
    }
}
package com.janson653.basicexecise.basic;

import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

public class MyReentranLock {
    public void acquire(long arg) {
        sync.acquire(arg);
    }

    public boolean release(long arg) {
        return sync.release(arg);
    }

    Sync sync;

    //<editor-fold desc="Description">
    class Sync extends AbstractQueuedLongSynchronizer {

    }
    //</editor-fold>
    public static void main(String[] args) {
        System.out.println("hello world");
        Person p = new Worker();
        ((Worker) p).getRole();
        for(StackTraceElement e: Thread.currentThread().getStackTrace()) {
            System.out.println(e.getClassName() + "---->" + e.getMethodName() + "---->" + e.getLineNumber());
        }
    }
}

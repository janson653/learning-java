package com.janson653.basicexecise.thread;

/**
 * @author zhangqian
 * @date 2021/6/2
 * 测试Thread正常接口
 */
public class MyThreadTest {
    public static void test1(int i) {
        if(i==0) {return;}
        System.out.println(i);
        i = i-1;
        test1(i);
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ThreadGroup("mythreadgrup"), new Runnable() {
            @Override
            public void run() {
                test1(222);
//                for (int i = 1; i < 10000000; i++) {
//                    while (Thread.interrupted()) {
//                        System.out.println("线程被中断，退出任务");
//                        return;
//                    }
//                    System.out.println("i=" + i);
//
//
//                }
            }
        }, "mythread1",2);
        thread.setDaemon(true);


        thread.start();

        Thread.sleep(100);
//        thread.interrupt();

        thread.join();
    }
}

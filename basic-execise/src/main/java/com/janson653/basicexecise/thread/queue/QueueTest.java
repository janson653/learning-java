package com.janson653.basicexecise.thread.queue;

import org.springframework.util.StopWatch;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangqian
 * @date 2021/6/8
 */
public class QueueTest {
    static AtomicInteger eventId = new AtomicInteger(1);
    static int TOTAL_EVENT_NUM = 1000000;
    static int THREAD_NUM = 16;
    static int EACH_THREAD_NUM = TOTAL_EVENT_NUM / THREAD_NUM;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch consumerLatch = new CountDownLatch(TOTAL_EVENT_NUM);
        // given: queue, producer, consumer
//        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
        BlockingQueue<String> queue = new SynchronousQueue();


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i = 1; i <= THREAD_NUM; i++) {
            Producer producer = new Producer(queue);
            producer.start();
        }

        for (int i = 1; i <= THREAD_NUM; i++) {
            Consumer consumer = new Consumer(queue, consumerLatch);
            consumer.start();
        }

        consumerLatch.await();
        stopWatch.stop();
        System.out.println("cost: " + stopWatch.getTotalTimeMillis());
    }

    private static class Producer extends Thread {
        final BlockingQueue<String> queue;

        public Producer(BlockingQueue<String> queue) {
            super("producer");
            this.queue = queue;
        }

        public void work() {
            try {
                for (int i = 1; i <= EACH_THREAD_NUM; i++) {
                    int id = eventId.getAndAdd(1);
                    String event = "start_event-" + id;
//                    System.out.println("produce event:" + event);
                    queue.put(event);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            this.work();
        }
    }

    private static class Consumer extends Thread {
        final BlockingQueue<String> queue;
        final CountDownLatch countDownLatch;


        public Consumer(BlockingQueue<String> queue, CountDownLatch countDownLatch) {
            super("consumer");
            this.queue = queue;
            this.countDownLatch = countDownLatch;
        }

        public void work() {
            try {
                while (true) {
                    String event = queue.take();
                    System.out.println("consume event:" + event);
                    Thread.sleep(10);
                    countDownLatch.countDown();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            this.work();
        }
    }
}

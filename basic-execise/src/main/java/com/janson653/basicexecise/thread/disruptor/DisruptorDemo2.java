package com.janson653.basicexecise.thread.disruptor;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import org.springframework.util.StopWatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class DisruptorDemo2 {
    static AtomicInteger eventId = new AtomicInteger(1);
    static int TOTAL_EVENT_NUM = 10000_0000;

    public static void main(String[] args) throws InterruptedException {
        Disruptor<OrderEvent> disruptor = new Disruptor<>(
                OrderEvent::new,
                1024 * 1024,
                Executors.defaultThreadFactory(),
                ProducerType.SINGLE,
                new YieldingWaitStrategy()
        );

        CountDownLatch consumerLatch = new CountDownLatch(TOTAL_EVENT_NUM);


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // 设置消费者
        disruptor.handleEventsWithWorkerPool(new OrderEventHandler(consumerLatch));
        disruptor.start();


        RingBuffer<OrderEvent> ringBuffer = disruptor.getRingBuffer();
        OrderEventProducer eventProducer = new OrderEventProducer(ringBuffer);

        // 创建一个线程池，模拟多个生产者
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 1; i <= TOTAL_EVENT_NUM; i++) {
                        int id = eventId.getAndAdd(1);
                        eventProducer.onData("" + id);
                    }
                }
            });
        }

        consumerLatch.await();
        stopWatch.stop();
        System.out.println("cost: " + stopWatch.getTotalTimeMillis());
    }
}

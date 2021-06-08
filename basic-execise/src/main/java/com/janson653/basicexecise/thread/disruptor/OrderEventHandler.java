package com.janson653.basicexecise.thread.disruptor;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class OrderEventHandler implements EventHandler<OrderEvent>, WorkHandler<OrderEvent> {
    private CountDownLatch countDownLatch;

    public OrderEventHandler(CountDownLatch countDownLatch) {
        super();
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) {
        log.info("event: {}, sequence: {}, endOfBatch: {}", event, sequence, endOfBatch);
    }

    @Override
    public void onEvent(OrderEvent event) {
        log.info("event: {}", event.getId());
//        try {
//            Thread.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        countDownLatch.countDown();
    }
}

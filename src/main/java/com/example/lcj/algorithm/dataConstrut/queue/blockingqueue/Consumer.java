package com.example.lcj.algorithm.dataConstrut.queue.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/28 22:45
 */
public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object take = queue.take();
                System.out.println(Thread.currentThread().getName() + "消费");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.lcj.algorithm.dataConstrut.queue.blockingqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/28 22:42
 */
public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                queue.add(new Object());
                System.out.println(Thread.currentThread().getName() + "生产");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

package com.example.lcj.thread.threadPool.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ：lcj
 *         @description：
 *         核心线程数和最大线程数大小一样
 *         没有所谓的非空闲时间，即keepAliveTime为0
 *         阻塞队列为无界队列LinkedBlockingQueue
 * @date ：Created in 2020/9/10 20:24
 */
public class NewFixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // do nothing
                }
            });
        }
    }
}

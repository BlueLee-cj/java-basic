package com.example.lcj.thread.threadPool.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 * @description：
 * 核心线程数为1
 * 最大线程数也为1
 * 阻塞队列是LinkedBlockingQueue
 * keepAliveTime为0
 * @date ：Created in 2020/9/10 20:24
 */
public class NewSingleThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName()+"正在执行");
            });
        }
    }
}

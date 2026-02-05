package com.example.lcj.thread.threadPool.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 *         @description：
 *         核心线程数为0
 *         最大线程数为Integer.MAX_VALUE
 *         阻塞队列是SynchronousQueue
 *         非核心线程空闲存活时间为60秒
 *         当提交任务的速度大于处理任务的速度时，每次提交一个任务，就必然会创建一个线程。
 *         极端情况下会创建过多的线程，耗尽 CPU 和内存资源。
 *         由于空闲 60 秒的线程会被终止，长时间保持空闲的 CachedThreadPool 不会占用任何资源。
 * @date ：Created in 2020/9/10 20:24
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "正在执行");
            });
        }
    }
}



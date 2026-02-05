package com.example.lcj.thread.threadPool.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author ：lcj
 *         @description：
 *         最大线程数为Integer.MAX_VALUE
 *         阻塞队列是DelayedWorkQueue
 *         keepAliveTime为0
 *         scheduleAtFixedRate() ：按某种速率周期执行
 *         scheduleWithFixedDelay()：在某个延迟后执行
 * @date ：Created in 2020/9/10 20:24
 */
public class NewScheduledThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            System.out.println("current Time" + System.currentTimeMillis());
            System.out.println(Thread.currentThread().getName() + "正在执行");
        }, 1, 3, TimeUnit.SECONDS);
    }
}

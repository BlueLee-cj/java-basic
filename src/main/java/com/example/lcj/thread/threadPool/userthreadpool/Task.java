package com.example.lcj.thread.threadPool.userthreadpool;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 19:43
 */
public class Task implements Runnable {
    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println("running_" + count.getAndIncrement());
    }
}

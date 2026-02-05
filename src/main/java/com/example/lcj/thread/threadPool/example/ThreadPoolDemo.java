package com.example.lcj.thread.threadPool.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main1(String[] args) {
        int nThreads = 10;
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(nThreads);
        executorService.execute(() -> System.out.println("Test"));
        System.out.println("-------------");
    }

    public static void main(String[] args) throws InterruptedException {
        int nThreads =10;
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(nThreads);
        // 允许核心线程池超时，超时时间为2s
        executorService.setKeepAliveTime(5L, TimeUnit.SECONDS);
        executorService.allowCoreThreadTimeOut(true);
        executorService.execute(()-> System.out.println("Test"));
    }
}

package com.example.lcj.thread.threadPool.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lichengjian
 * @date 2021/7/2
 */
public class Test {
    public static void main(String[] args) {
        // 定义一个任务
        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Test");
        };

        // 长度为10的定长线程池
        int nThreads = 10;
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(nThreads);
        // 给线程池起个名字
        // executorService.setThreadFactory(new BasicThreadFactory("定长线程池"));

        // 执行两次任务（第二次执行时第一次还没结束）
        executorService.execute(runnable);
        executorService.execute(runnable);
        // 活跃线程数
        System.out.println(executorService.getActiveCount());
    }
}

package com.example.lcj.thread.threadPool.pool;

import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JDKThreadPoolExecutorTest {

    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

        executor.execute(() -> {
            System.out.println("关注why技术0");
        });

        Future<String> future1 = executor.submit(() -> {
            System.out.println("关注why技术1");
            return "这次一定！";
        });
        System.out.println("future1的内容:" + future1.get());


        Future<?> future2 = executor.submit(() -> {
            System.out.println("关注why技术2");
        });
        System.out.println("future2的内容:" + future2.get());

        AtomicInteger atomicInteger = new AtomicInteger();
        Future<AtomicInteger> future = executor.submit(() -> {
            System.out.println("关注why技术");
            //在这里进行计算逻辑
            atomicInteger.set(5201314);
        }, atomicInteger);

        System.out.println("future的内容:" + future.get());
        Thread.currentThread().join();
    }
}

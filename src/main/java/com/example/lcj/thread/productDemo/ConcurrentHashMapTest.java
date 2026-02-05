package com.example.lcj.thread.productDemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/6/7 17:03
 */
public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            testConcurrentMap();
        }
    }

    private static void testConcurrentMap() {
        final Map<String, Integer> count = new ConcurrentHashMap<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        final CountDownLatch endLatch = new CountDownLatch(2);
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                Integer value = count.get("k");
                if (null == value) {
                    System.out.println(Thread.currentThread().getName());
                    count.putIfAbsent("k", 1);
                } else {
                    count.putIfAbsent("k", value + 1);
                }
            }
            endLatch.countDown();
        };

        executorService.execute(task);
        executorService.execute(task);

        try {
            endLatch.await();
            if (count.get("k") < 10) {
                System.out.println(count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

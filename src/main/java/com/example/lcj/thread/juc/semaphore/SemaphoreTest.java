package com.example.lcj.thread.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 14:35
 */
public class SemaphoreTest {

    private static final int THREADS_COUNT = 30;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_COUNT);

    private static Semaphore semaphore = new Semaphore(10);

    public static void main(String[] args) {
        for (int i = 0; i < THREADS_COUNT; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("save data " + System.currentTimeMillis());
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        threadPool.shutdown();
    }
}

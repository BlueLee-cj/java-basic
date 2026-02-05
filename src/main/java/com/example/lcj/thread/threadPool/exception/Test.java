package com.example.lcj.thread.threadPool.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/10 14:53
 */
public class Test {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            threadPool.submit(() -> {
                System.out.println("current thread name" + Thread.currentThread().getName());
                Object object = null;
                System.out.print("result## " + object.toString());
            });
        }
    }
}

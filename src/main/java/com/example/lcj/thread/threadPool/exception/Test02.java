package com.example.lcj.thread.threadPool.exception;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/10 14:53
 */
public class Test02 {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            Future<?> future = threadPool.submit(() -> {
                System.out.println("current thread name" + Thread.currentThread().getName());
                Object object = null;
                System.out.print("result## " + object.toString());
            });

            try {
                future.get();
            } catch (Exception e) {
                System.out.println("发生异常");
                e.printStackTrace();
            }

        }
    }
}

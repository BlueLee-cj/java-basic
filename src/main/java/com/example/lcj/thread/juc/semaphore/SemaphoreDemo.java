package com.example.lcj.thread.juc.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * TODO Semaphore 示例
 *
 * @author liuzebiao
 * @Date 2020-4-30 16:23
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 创建一个无界线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 配置只能5个线程同时访问
        final Semaphore semaphore = new Semaphore(5);
        // 模拟20个客户端访问
        for (int i = 0; i < 10; i++) {
            int num = i;
            Runnable task = (() -> {
                try {
                    // 获取许可
                    semaphore.acquire();
                    System.out.println("获得许可: " + num);
                    // 休眠随机秒(表示正在执行操作)
                    TimeUnit.SECONDS.sleep((int) (Math.random() * 10 + 1));
                    // 访问完后，释放许可
                    semaphore.release();
                    // availablePermits()指还剩多少个许可
                    System.out.println("----------当前还有多少个许可:" + semaphore.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            exec.execute(task);
        }
        // 退出线程池
        exec.shutdown();
    }
}

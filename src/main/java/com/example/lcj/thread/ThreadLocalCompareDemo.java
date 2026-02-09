package com.example.lcj.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalCompareDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(1); // 只有1个线程

        // 任务1
        pool.submit(() -> {
            int localVar = 100;                    // 局部变量
            threadLocal.set("任务1的数据");         // ThreadLocal

            System.out.println("任务1 - 局部变量: " + localVar);
            System.out.println("任务1 - ThreadLocal: " + threadLocal.get());

            // 忘记 remove() 了！
        });

        // 等一下，确保任务1先执行完
        Thread.sleep(100);

        // 任务2（复用同一个线程）
        pool.submit(() -> {
            int localVar = 200;                    // 新的局部变量

            System.out.println("任务2 - 局部变量: " + localVar);           // 200 ✓
            System.out.println("任务2 - ThreadLocal: " + threadLocal.get()); // "任务1的数据" ✗
        });
    }
}

// 输出：
// 任务1 - 局部变量: 100
// 任务1 - ThreadLocal: 任务1的数据
// 任务2 - 局部变量: 200          ← 正确，是新的局部变量
// 任务2 - ThreadLocal: 任务1的数据 ← 错误！拿到了任务1的脏数据

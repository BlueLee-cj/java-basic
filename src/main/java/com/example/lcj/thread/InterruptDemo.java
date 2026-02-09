package com.example.lcj.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程中断机制演示
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 线程中断机制演示 ===\n");
        
        // 1. 基本中断
        testBasicInterrupt();
        
        // 2. 中断阻塞线程（sleep/wait/join）
        testInterruptBlocking();
        
        // 3. isInterrupted vs interrupted
        testInterruptedMethods();
        
        // 4. 正确处理中断的方式
        testProperInterruptHandling();
    }

    /**
     * 1. 基本中断：中断一个正在运行的线程
     */
    static void testBasicInterrupt() throws InterruptedException {
        System.out.println("========== 1. 基本中断 ==========");
        
        Thread t = new Thread(() -> {
            int count = 0;
            // 通过检查中断标志来决定是否退出
            while (!Thread.currentThread().isInterrupted()) {
                count++;
                if (count % 10000000 == 0) {
                    System.out.println("工作中... count=" + count);
                }
            }
            System.out.println("检测到中断，优雅退出。最终 count=" + count);
        }, "Worker");
        
        t.start();
        
        // 让线程运行一会儿
        Thread.sleep(100);
        
        // 发送中断信号
        System.out.println("主线程：发送中断信号");
        t.interrupt();
        
        t.join();
        System.out.println();
    }

    /**
     * 2. 中断阻塞线程：sleep/wait/join 会抛出 InterruptedException
     */
    static void testInterruptBlocking() throws InterruptedException {
        System.out.println("========== 2. 中断阻塞线程 ==========");
        
        Thread t = new Thread(() -> {
            try {
                System.out.println("线程开始睡眠 10 秒...");
                Thread.sleep(10000);  // 睡眠 10 秒
                System.out.println("睡眠结束");
            } catch (InterruptedException e) {
                // sleep 被中断时抛出异常，并且中断标志被清除！
                System.out.println("睡眠被中断！");
                System.out.println("中断标志（被清除了）: " + Thread.currentThread().isInterrupted());
            }
        }, "Sleeper");
        
        t.start();
        
        // 等 1 秒后中断
        Thread.sleep(1000);
        System.out.println("主线程：中断睡眠中的线程");
        t.interrupt();
        
        t.join();
        System.out.println();
    }

    /**
     * 3. isInterrupted() vs Thread.interrupted()
     */
    static void testInterruptedMethods() throws InterruptedException {
        System.out.println("========== 3. isInterrupted vs interrupted ==========");
        
        Thread t = new Thread(() -> {
            // 先设置中断标志
            Thread.currentThread().interrupt();
            
            // isInterrupted() - 不清除标志
            System.out.println("第1次 isInterrupted(): " + Thread.currentThread().isInterrupted());
            System.out.println("第2次 isInterrupted(): " + Thread.currentThread().isInterrupted());
            
            // Thread.interrupted() - 清除标志
            System.out.println("第1次 Thread.interrupted(): " + Thread.interrupted());
            System.out.println("第2次 Thread.interrupted(): " + Thread.interrupted());  // 已被清除，返回 false
            
        }, "TestInterrupted");
        
        t.start();
        t.join();
        System.out.println();
    }

    /**
     * 4. 正确处理中断的方式
     */
    static void testProperInterruptHandling() throws InterruptedException {
        System.out.println("========== 4. 正确处理中断 ==========");
        
        Thread t = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // 模拟工作
                    doWork();
                }
            } catch (InterruptedException e) {
                // 方式1：重新设置中断标志（推荐）
                Thread.currentThread().interrupt();
                System.out.println("捕获中断异常，重新设置中断标志");
            }
            
            // 清理工作
            System.out.println("执行清理工作...");
            System.out.println("线程优雅退出");
        }, "ProperHandler");
        
        t.start();
        
        Thread.sleep(500);
        System.out.println("主线程：发送中断信号");
        t.interrupt();
        
        t.join();
        System.out.println();
    }
    
    static void doWork() throws InterruptedException {
        // 模拟一些工作，包含可能阻塞的操作
        Thread.sleep(100);
        System.out.println("工作中...");
    }
}

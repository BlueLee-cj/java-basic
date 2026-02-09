package com.example.lcj.thread;

/**
 * volatile 关键字演示
 */
public class VolatileDemo {

    // 没有 volatile，可能导致可见性问题
    private static boolean flagWithoutVolatile = false;
    
    // 有 volatile，保证可见性
    private static volatile boolean flagWithVolatile = false;
    
    // 演示原子性问题
    private static volatile int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== volatile 关键字演示 ===\n");
        
        // 1. 可见性问题演示
        testVisibility();
        
        // 2. volatile 解决可见性
        testVolatileVisibility();
        
        // 3. volatile 不保证原子性
        testVolatileNotAtomic();
    }

    /**
     * 1. 没有 volatile 的可见性问题
     * 注意：这个问题不一定每次都能复现，取决于 JVM 优化
     */
    static void testVisibility() throws InterruptedException {
        System.out.println("========== 1. 没有 volatile 的可见性问题 ==========");
        
        flagWithoutVolatile = false;
        
        // 线程A：等待 flag 变为 true
        Thread threadA = new Thread(() -> {
            System.out.println("线程A：等待 flag 变为 true...");
            while (!flagWithoutVolatile) {
                // 空循环，等待 flag 变化
                // JIT 可能优化成：if (!flag) while(true) {}
            }
            System.out.println("线程A：检测到 flag 为 true，退出");
        }, "ThreadA");
        
        threadA.start();
        
        // 主线程等待一会儿，然后修改 flag
        Thread.sleep(100);
        System.out.println("主线程：设置 flag = true");
        flagWithoutVolatile = true;
        
        // 等待线程A结束（设置超时，避免死循环）
        threadA.join(2000);
        
        if (threadA.isAlive()) {
            System.out.println("线程A：仍在运行（没有看到 flag 的变化）！");
            threadA.interrupt();  // 强制中断
        }
        System.out.println();
    }

    /**
     * 2. volatile 解决可见性问题
     */
    static void testVolatileVisibility() throws InterruptedException {
        System.out.println("========== 2. volatile 解决可见性问题 ==========");
        
        flagWithVolatile = false;
        
        // 线程A：等待 flag 变为 true
        Thread threadA = new Thread(() -> {
            System.out.println("线程A：等待 volatile flag 变为 true...");
            while (!flagWithVolatile) {
                // 每次读取都从主内存获取最新值
            }
            System.out.println("线程A：检测到 flag 为 true，退出");
        }, "ThreadA-Volatile");
        
        threadA.start();
        
        Thread.sleep(100);
        System.out.println("主线程：设置 volatile flag = true");
        flagWithVolatile = true;
        
        threadA.join(2000);
        
        if (threadA.isAlive()) {
            System.out.println("线程A：仍在运行");
            threadA.interrupt();
        } else {
            System.out.println("线程A：正常退出（volatile 保证了可见性）");
        }
        System.out.println();
    }

    /**
     * 3. volatile 不保证原子性
     */
    static void testVolatileNotAtomic() throws InterruptedException {
        System.out.println("========== 3. volatile 不保证原子性 ==========");
        
        counter = 0;
        
        // 创建 10 个线程，每个线程对 counter 加 1000 次
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter++;  // 不是原子操作！
                }
            });
            threads[i].start();
        }
        
        // 等待所有线程完成
        for (Thread t : threads) {
            t.join();
        }
        
        System.out.println("期望结果：10000");
        System.out.println("实际结果：" + counter);
        System.out.println("结论：volatile 不保证原子性，counter++ 会丢失更新");
        System.out.println();
    }
}

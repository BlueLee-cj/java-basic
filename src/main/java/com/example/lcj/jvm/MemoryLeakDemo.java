package com.example.lcj.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 内存泄漏演示
 * 
 * 运行参数：-Xms64m -Xmx64m -XX:+HeapDumpOnOutOfMemoryError
 */
public class MemoryLeakDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== 内存泄漏演示 ===\n");
        System.out.println("请选择演示类型：");
        System.out.println("1. 静态集合泄漏");
        System.out.println("2. ThreadLocal 泄漏");
        System.out.println("3. 缓存无限增长");
        
        // 默认演示静态集合泄漏
        staticCollectionLeak();
    }

    // ==================== 案例 1：静态集合泄漏 ====================
    
    private static List<byte[]> staticList = new ArrayList<>();
    
    public static void staticCollectionLeak() {
        System.out.println("\n>>> 静态集合泄漏演示");
        System.out.println("每次添加 1MB 数据到静态 List...\n");
        
        int count = 0;
        try {
            while (true) {
                // 每次添加 1MB
                staticList.add(new byte[1024 * 1024]);
                count++;
                System.out.println("已添加 " + count + " MB");
                Thread.sleep(100);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("\n❌ OOM! 已添加 " + count + " MB 后内存耗尽");
            System.out.println("原因：静态集合持有所有对象引用，GC 无法回收");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ==================== 案例 2：ThreadLocal 泄漏 ====================
    
    private static ThreadLocal<byte[]> threadLocal = new ThreadLocal<>();
    
    public static void threadLocalLeak() {
        System.out.println("\n>>> ThreadLocal 泄漏演示");
        System.out.println("在线程池中使用 ThreadLocal 但不清理...\n");
        
        // 固定大小线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        int count = 0;
        try {
            while (true) {
                final int taskId = count++;
                executor.submit(() -> {
                    // ❌ 设置了 ThreadLocal 但没有 remove
                    threadLocal.set(new byte[1024 * 1024]);  // 1MB
                    System.out.println("Task " + taskId + " 设置了 1MB ThreadLocal");
                    
                    // 模拟业务处理
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    
                    // ❌ 忘记 remove！
                    // threadLocal.remove();
                });
                
                Thread.sleep(50);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("\n❌ OOM! 执行了 " + count + " 个任务后内存耗尽");
            System.out.println("原因：线程池复用线程，ThreadLocal 未清理导致内存泄漏");
            executor.shutdown();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ==================== 案例 3：缓存无限增长 ====================
    
    private static Map<Integer, byte[]> cache = new HashMap<>();
    
    public static void cacheLeak() {
        System.out.println("\n>>> 缓存无限增长演示");
        System.out.println("模拟无过期策略的缓存...\n");
        
        int count = 0;
        try {
            while (true) {
                // 模拟不同的 key，导致缓存无限增长
                cache.put(count, new byte[1024 * 100]);  // 100KB
                count++;
                
                if (count % 100 == 0) {
                    System.out.println("缓存大小: " + count + " 条，约 " + (count * 100 / 1024) + " MB");
                }
                
                Thread.sleep(10);
            }
        } catch (OutOfMemoryError e) {
            System.out.println("\n❌ OOM! 缓存 " + count + " 条后内存耗尽");
            System.out.println("原因：缓存没有大小限制和过期策略");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // ==================== 正确做法演示 ====================
    
    /**
     * 正确使用 ThreadLocal
     */
    public static void threadLocalCorrect() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        executor.submit(() -> {
            try {
                threadLocal.set(new byte[1024 * 1024]);
                // 业务逻辑...
            } finally {
                threadLocal.remove();  // ✅ 必须清理
            }
        });
        
        executor.shutdown();
    }
}

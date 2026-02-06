package com.example.lcj.thread.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 使用读写锁实现的线程安全缓存
 */
public class ReadWriteCache<K, V> {

    private final Map<K, V> cache = new HashMap<>();
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    // 读操作 - 共享锁（多个线程可以同时读）
    public V get(K key) {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 读取: " + key);
            return cache.get(key);
        } finally {
            readLock.unlock();
        }
    }

    // 写操作 - 独占锁（只有一个线程可以写）
    public void put(K key, V value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " 写入: " + key + "=" + value);
            // Thread.sleep(1000);
            cache.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    // 删除操作 - 独占锁
    public void remove(K key) {
        writeLock.lock();
        try {
            cache.remove(key);
        } finally {
            writeLock.unlock();
        }
    }

    // 清空缓存 - 独占锁
    public void clear() {
        writeLock.lock();
        try {
            cache.clear();
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteCache<String, String> cache = new ReadWriteCache<>();

        // 先写入一些数据
        cache.put("name", "张三");
        cache.put("age", "25");

        // 启动多个读线程（可以并发）
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                System.out.println("读取结果: " + cache.get("name"));
            }, "读线程-" + i).start();
        }

        // 启动写线程（会阻塞读线程）
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                cache.put("name", "李四");
            }, "写线程-" + i).start();
        }
        Thread.sleep(1000);
    }
}

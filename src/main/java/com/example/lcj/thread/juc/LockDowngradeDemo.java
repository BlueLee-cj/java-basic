package com.example.lcj.thread.juc;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 锁降级示例：持有写锁时获取读锁，然后释放写锁
 * 用途：保证数据修改后的可见性
 */
public class LockDowngradeDemo {

    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    private volatile boolean cacheValid = false;
    private Object data;

    public Object getData() {
        readLock.lock();  // 先获取读锁
        try {
            if (!cacheValid) {
                // 缓存失效，需要更新
                readLock.unlock();  // 必须先释放读锁
                writeLock.lock();   // 再获取写锁
                try {
                    // 双重检查
                    if (!cacheValid) {
                        data = loadDataFromDB();  // 加载数据
                        cacheValid = true;
                    }
                    // 🔑 锁降级：在释放写锁前，先获取读锁
                    readLock.lock();
                } finally {
                    writeLock.unlock();  // 释放写锁，但仍持有读锁
                }
            }
            // 此时持有读锁，可以安全读取
            return data;
        } finally {
            readLock.unlock();
        }
    }

    private Object loadDataFromDB() {
        System.out.println("从数据库加载数据...");
        return "数据内容";
    }

    public void invalidateCache() {
        writeLock.lock();
        try {
            cacheValid = false;
        } finally {
            writeLock.unlock();
        }
    }
}

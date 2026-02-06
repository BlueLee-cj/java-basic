package com.example.lcj.thread.kechongru;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lichengjian
 * @date 2026/2/5
 */
public class ReentrantLockTest {

    ReentrantLock lock = new ReentrantLock();

    public void methodA() {
        lock.lock();
        try {
            System.out.println("AAA");
            methodB();  // 在持有锁的情况下，再次获取同一把锁
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        lock.lock();  // ✅ 可以再次获取！因为是同一个线程
        try {
            System.out.println("BBB");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new ReentrantLockTest().methodA();
    }
}

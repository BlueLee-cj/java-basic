package com.example.lcj.thread.T41100ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/12 22:27
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName());
        }
        lock.unlock();
    }
}

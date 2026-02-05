package com.example.lcj.thread.T41100getQueueLength;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/8 12:47
 */
public class Service {
    public ReentrantLock lock = new ReentrantLock();

    public void serviceMethod1() {
        try {
            lock.lock();
            System.out.println("ThreadName = " + Thread.currentThread().getName() + "进入方法！");
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

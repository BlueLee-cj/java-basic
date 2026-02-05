package com.example.lcj.thread.T3130WaitAndNotify;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 20:58
 */
public class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            System.out.println("开始 notify time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束 notify time=" + System.currentTimeMillis());
        }
    }
}

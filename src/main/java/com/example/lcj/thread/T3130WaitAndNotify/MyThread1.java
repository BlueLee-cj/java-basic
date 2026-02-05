package com.example.lcj.thread.T3130WaitAndNotify;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 20:58
 */
public class MyThread1 extends Thread {
    private Object lock;

    public MyThread1(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始A wait time=" + System.currentTimeMillis());
                lock.wait();
                System.out.println("结束A wait time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

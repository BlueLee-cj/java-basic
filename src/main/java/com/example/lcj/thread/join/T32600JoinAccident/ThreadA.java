package com.example.lcj.thread.join.T32600JoinAccident;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:41
 */
public class ThreadA extends Thread {
    private ThreadB b;

    public ThreadA(ThreadB b) {
        this.b = b;
    }

    @Override
    public void run() {
        try {
            synchronized (b) {
                System.out.println("a begin time = " + System.currentTimeMillis());
                Thread.sleep(5000);
                System.out.println("a end time = " + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

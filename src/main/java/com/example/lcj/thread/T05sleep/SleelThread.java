package com.example.lcj.thread.T05sleep;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 14:45
 */
public class SleelThread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("run threadName=" + this.currentThread().getName() + " begin=" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("run threadName=" + this.currentThread().getName() + " end=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SleelThread sleelThread = new SleelThread();
        System.out.println("bein=" + System.currentTimeMillis());
        sleelThread.start();
        Thread.sleep(1000);
        System.out.println("end=" + System.currentTimeMillis());
    }
}

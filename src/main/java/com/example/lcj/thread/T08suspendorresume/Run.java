package com.example.lcj.thread.T08suspendorresume;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 15:59
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(5000);
        thread.suspend();
        System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());
        Thread.sleep(5000);
        System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());

        thread.resume();
        Thread.sleep(5000);


        thread.suspend();
        System.out.println("B=" + System.currentTimeMillis() + " i=" + thread.getI());
        Thread.sleep(5000);
        System.out.println("B=" + System.currentTimeMillis() + " i=" + thread.getI());
    }
}

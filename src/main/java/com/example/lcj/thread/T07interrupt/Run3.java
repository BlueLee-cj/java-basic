package com.example.lcj.thread.T07interrupt;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/9 9:11
 */
public class Run3 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
        myThread.interrupt();
        System.out.println("是否停止1？=" + myThread.isInterrupted());
        System.out.println("是否停止2？=" + myThread.isInterrupted());
    }
}

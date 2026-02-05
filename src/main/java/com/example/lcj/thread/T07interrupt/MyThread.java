package com.example.lcj.thread.T07interrupt;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 15:08
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        System.out.println("是否停止1?" + myThread.interrupted());
        //public static boolean interrupted() 判断是当前线程是否已中断，此当前线程为main
        System.out.println("是否停止2?" + myThread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println("是否停止1?" + Thread.interrupted());
        System.out.println("是否停止2?" + Thread.interrupted());
    }
}




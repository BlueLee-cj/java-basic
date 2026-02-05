package com.example.lcj.thread.T2340VolatileNotAtomic;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 18:03
 */
public class MyThread extends Thread {
    public static int count;

    synchronized private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count = " + count);
    }

    @Override
    public void run() {
        addCount();
    }
}

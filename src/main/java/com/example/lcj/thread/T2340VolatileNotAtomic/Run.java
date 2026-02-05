package com.example.lcj.thread.T2340VolatileNotAtomic;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 18:05
 */
public class Run {
    public static void main(String[] args) {
        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i] = new MyThread();
        }
        for (int i = 0; i < 100; i++) {
            myThreads[i].start();
        }
    }
}

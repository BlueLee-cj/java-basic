package com.example.lcj.thread.T224HalfSyncHalfNotSync;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 10:17
 */
public class Task {
    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadname = " + Thread.currentThread().getName() + " i= " + (i + 1));
        }
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadname = " + Thread.currentThread().getName() + " i= " + (i + 1));
            }
        }
    }

}

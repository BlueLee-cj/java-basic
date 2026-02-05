package com.example.lcj.thread.T214SynchronizedAndLockObject.SameObjectDifferentSychMethod;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:25
 */
public class MyObject {
    synchronized public void methodA() {
        try {
            System.out.println("begin methodA threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end A");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public void methodB() {
        try {
            System.out.println("begin methodB threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end B");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

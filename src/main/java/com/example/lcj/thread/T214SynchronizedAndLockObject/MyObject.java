package com.example.lcj.thread.T214SynchronizedAndLockObject;

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
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

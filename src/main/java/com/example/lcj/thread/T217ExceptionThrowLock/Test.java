package com.example.lcj.thread.T217ExceptionThrowLock;

import sun.rmi.runtime.NewThreadAction;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 10:01
 */
public class Test {
    public static void main(String[] args) {
        try {
            Service service = new Service();
            ThreadA a = new ThreadA(service);
            a.setName("a");
            a.start();
            Thread.sleep(500);
            ThreadB b = new ThreadB(service);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

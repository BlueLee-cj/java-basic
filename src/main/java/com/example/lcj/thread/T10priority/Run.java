package com.example.lcj.thread.T10priority;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:02
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        a.setPriority(Thread.NORM_PRIORITY - 3);
        a.start();
        ThreadB b = new ThreadB();
        b.setPriority(Thread.NORM_PRIORITY + 3);
        b.start();
        Thread.sleep(10000);
        a.stop();
        b.stop();
        System.out.println("a=" + a.getCount());
        System.out.println("b=" + b.getCount());
    }
}

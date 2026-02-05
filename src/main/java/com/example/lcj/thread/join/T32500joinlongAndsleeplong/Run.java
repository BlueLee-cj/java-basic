package com.example.lcj.thread.join.T32500joinlongAndsleeplong;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:45
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);
        a.start();
        Thread.sleep(1000);
        ThreadC c = new ThreadC(b);
        c.start();
    }
}

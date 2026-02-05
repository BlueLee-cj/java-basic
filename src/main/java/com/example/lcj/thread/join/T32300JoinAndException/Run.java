package com.example.lcj.thread.join.T32300JoinAndException;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/7 12:45
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        b.start();
        Thread.sleep(500);
        ThreadC c = new ThreadC(b);
        c.start();
    }
}

package com.example.lcj.thread.T3110WaitConditionChange;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:56
 */
public class ThreadSun extends Thread {
    private Substract r;

    public ThreadSun(Substract r) {
        this.r = r;
    }

    @Override
    public void run() {
        r.substract();
    }
}

package com.example.lcj.thread.T3110WaitConditionChange;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:56
 */
public class ThreadAdd extends Thread {
    private Add p;

    public ThreadAdd(Add p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.add();
    }
}

package com.example.lcj.thread.T3111ProduerAndComsuer;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/10 21:42
 */
public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    @Override
    public void run() {
        while (true) {
            c.getValue();
        }
    }
}

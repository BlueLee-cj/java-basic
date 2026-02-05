package com.example.lcj.thread.T3111ProduerAndComsuer;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/10 21:42
 */
public class ThreadP extends Thread {
    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }
}

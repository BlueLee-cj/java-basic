package com.example.lcj.thread.T3111ProduerAndComsuer;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/10 21:44
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP threadP = new ThreadP(p);
        ThreadC threadC = new ThreadC(c);
        threadP.start();
        threadC.start();

    }
}

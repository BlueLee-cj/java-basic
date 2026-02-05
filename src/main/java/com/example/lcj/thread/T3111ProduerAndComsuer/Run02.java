package com.example.lcj.thread.T3111ProduerAndComsuer;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/10 21:44
 */
public class Run02 {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);
        ThreadP[] pthread = new ThreadP[2];
        ThreadC[] cthread = new ThreadC[2];
        for (int i = 0; i < 2; i++) {
            pthread[i] = new ThreadP(p);
            pthread[i].setName("生产者" + i + 1);
            cthread[i] = new ThreadC(c);
            cthread[i].setName("消费者" + i + 1);
            pthread[i].start();
            cthread[i].start();

        }
        Thread.sleep(5000);
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        for (int i = 0; i < threads.length; i++) {
            System.out.println(threads[i].getName() + " " + threads[i].getState());
        }

    }
}

package com.example.lcj.thread.volatiledemo;

/**
 * @author ��lcj
 * @description��
 * @modified By��
 * @date ��Created in 2019/7/19 22:01
 */
public class VolatileAtomicTest01 {
    private static volatile int num = 0;

    public static synchronized void increase() {
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(num);
    }
}

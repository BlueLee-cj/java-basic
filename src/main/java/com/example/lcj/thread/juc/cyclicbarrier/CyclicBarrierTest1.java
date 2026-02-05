package com.example.lcj.thread.juc.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 14:23
 */
public class CyclicBarrierTest1 {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("111");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("222");
            }
        }).start();

        System.out.println("3");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("3333");
    }
}

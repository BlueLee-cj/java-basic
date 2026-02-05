package com.example.lcj.thread.juc.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest2 {
    public static void main(String[] args) {

        /**
         * Thread-1 在路上耗时0秒
         * Thread-2 在路上耗时2秒
         * Thread-1 到达车站了
         * Thread-0 在路上耗时3秒
         * Thread-2 到达车站了
         * Thread-0 到达车站了
         * 老司机，发车
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("老司机，发车");
        });
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                //返回[0,5)的值
                int time = random.nextInt(5);
                System.out.println(Thread.currentThread().getName() + " 在路上耗时" +
                        time + "秒");
                try {
                    TimeUnit.SECONDS.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 到达车站了");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

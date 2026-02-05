package com.example.lcj.thread.juc.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

import lombok.SneakyThrows;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(2);
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("1");
                count.countDown();
                count.await();
                System.out.println("111");
            }
        }).start();

        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("2");
                count.countDown();
                count.await();
                System.out.println("222");
            }
        }).start();

        count.await();
        System.out.println("3");
        System.out.println("所有线程执行完毕");

        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 准备完毕……运动员都阻塞在这，等待号令
                    countDownLatch.await();
                    String parter = "【" + Thread.currentThread().getName() + "】";
                    System.out.println(parter + "开始执行……");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        Thread.sleep(2000);// 裁判准备发令
        countDownLatch.countDown();// 发令枪：执行发令


        CountDownLatch countDownLatch1 = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                    countDownLatch1.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        countDownLatch1.await();// 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。
        System.out.println("主线程:在所有任务运行完成后，进行结果汇总");
    }
}

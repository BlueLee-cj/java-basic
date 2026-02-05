package com.example.lcj.thread.AQS.demo01_helloworld;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/9/2 21:01
 */
public class HelloWorld {
    private static  final  int MAX_THREADS = 10;//模拟10个用户
    private static CountDownLatch cdl = new CountDownLatch(MAX_THREADS);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < MAX_THREADS; i++){
            Thread t = new Thread(() -> {
                try {
                    cdl.countDown();//200--199--198
                    cdl.await(); //等待 阻塞 断点
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("123");
            });
            t.start();
        }
        Thread.sleep(200);
    }
}

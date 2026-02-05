package com.example.lcj.thread.juc.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 11:32
 */
public class CountDownLatchTest {
    public static void main( String[ ] args ) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        Thread thread1 = new TranslateThread ("lst context", count);
        Thread thread2 = new TranslateThread ("2nd context", count);
        Thread thread3 = new TranslateThread ("3rd content", count);
        thread1.start();
        thread2.start();
        thread3.start();
        count.await( 10, TimeUnit.SECONDS);
        System.out.println("所有线程执行完毕");
    }
}



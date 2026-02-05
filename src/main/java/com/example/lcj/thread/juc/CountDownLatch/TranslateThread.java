package com.example.lcj.thread.juc.CountDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 11:33
 */
public class TranslateThread extends Thread{
    private String contenxt;
    private final CountDownLatch count;

    public TranslateThread(String contenxt, CountDownLatch count) {
        this.contenxt = contenxt;
        this.count = count;
    }

    @Override
    public void run() {
        if (Math.random() > 0.5) {
            throw new RuntimeException("原文存在非法字符");
        }
        System.out.println(contenxt + "的翻译已经完成，译文为。。。。");
        count.countDown();
    }
}

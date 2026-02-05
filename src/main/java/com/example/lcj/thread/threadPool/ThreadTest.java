package com.example.lcj.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);

    public void dothing() {
        for (int i = 0; i < 50; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //do something
                }
            });
        }
        fixedThreadPool.shutdown();//关闭线程池

        //此处不可以删除或注释，需要线程执行结束后再执行别的内容,即只有线程结束后才会继续向下执行
        while (!fixedThreadPool.isTerminated()) {

        }
    }
}

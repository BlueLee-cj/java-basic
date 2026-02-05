package com.example.lcj.thread.T41100getQueueLength;

import com.example.lcj.thread.T3110WaitConditionChange.ThreadAdd;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/8 12:50
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final Service service = new Service();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                service.serviceMethod1();
            }
        };
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        Thread.sleep(2000);
        System.out.println("有线程数：" + service.lock.getQueueLength() + "在等货获取锁");
    }
}

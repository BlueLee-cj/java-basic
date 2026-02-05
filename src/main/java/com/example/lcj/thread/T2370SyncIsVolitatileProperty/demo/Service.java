package com.example.lcj.thread.T2370SyncIsVolitatileProperty.demo;

/**
 * @author ：lcj
 * @description：关键字synchronized可以保证同一时刻，只有一个线程可以执行某一个方法或某一个代码块； 他包含两个特征：互斥性和可见性.同步synchronized不仅可以解决一个线程看到对象出于不一致的状况，还可以
 * 保证进入同步方法或者同步代码块的每个线程，都看到由同一个锁保护之前所有的修改效果。
 * @modified By：
 * @date ：Created in 2019/8/4 20:10
 */
public class Service {
    private volatile boolean isContinueRun = true;

    public void runMethod() {
        String any = new String();
        while (isContinueRun == true) {
            //synchronized (this) {
            //
            //}
            //System.out.println("停不下来");
        }
        System.out.println("停下来了");
    }

    public void stopMethod() {
        isContinueRun = false;
    }
}

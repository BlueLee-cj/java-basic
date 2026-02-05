package com.example.lcj.thread.T02share;

public class MyThreadShare extends Thread {
    private int count = 5;

    //加锁为互斥区或临界区

    @Override
    synchronized public void run() {
        // TODO Auto-generated method stub
        super.run();
        count--;
        System.out.println("由" + Thread.currentThread().getName() + "计算,count=" + count);
    }
}

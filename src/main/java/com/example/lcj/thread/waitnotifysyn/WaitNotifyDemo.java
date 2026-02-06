package com.example.lcj.thread.waitnotifysyn;

public class WaitNotifyDemo {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        // 线程A：等待
        Thread threadA = new Thread(() -> {
            synchronized (lock) {
                System.out.println("A: 获取锁，准备 wait");
                try {
                    lock.wait();  // 释放锁，进入等待池
                } catch (InterruptedException e) { }
                System.out.println("A: 被唤醒，重新获取锁，继续执行");
            }
        }, "线程A");

        // 线程B：唤醒
        Thread threadB = new Thread(() -> {
            synchronized (lock) {
                System.out.println("B: 获取锁，准备 notify");
                lock.notify();  // 把A移到锁池，但B还没释放锁
                System.out.println("B: notify 完成，但还没释放锁");
                try {
                    Thread.sleep(2000);  // 模拟继续执行
                } catch (InterruptedException e) { }
                System.out.println("B: 现在释放锁");
            }
        }, "线程B");

        threadA.start();
        Thread.sleep(100);  // 确保A先执行
        threadB.start();
    }
}

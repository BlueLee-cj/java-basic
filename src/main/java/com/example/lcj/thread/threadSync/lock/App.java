package com.example.lcj.thread.threadSync.lock;

import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) throws Exception {
        final int[] counter = {0};
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        int a = counter[0];
                        counter[0] = a + 1;
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
        // ���߳����ߣ��ȴ����
        Thread.sleep(5000);
        System.out.println(counter[0]);
    }
}

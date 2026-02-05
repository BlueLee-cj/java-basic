package com.example.lcj.thread.T3180WaitLong;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:36
 */
public class MyRunnable {
    static private Object lock = new Object();
    static private Runnable runnable1 = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("wait begin timer" + System.currentTimeMillis());
                    lock.wait(3000);
                    System.out.println("wait end timer" + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        Thread t = new Thread(runnable1);
        t.start();
    }
}

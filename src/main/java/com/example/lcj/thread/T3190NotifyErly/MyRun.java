package com.example.lcj.thread.T3190NotifyErly;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/10 21:04
 */
public class MyRun {
    private String lock = new String("");
    private Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    System.out.println("bengin wait");
                    lock.wait();
                    System.out.println("end wait");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable runnableB = new Runnable() {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("begin notify");
                lock.notify();
                System.out.println("end notify");
            }
        }
    };

    public static void main(String[] args) {
        MyRun myRun = new MyRun();
        Thread b = new Thread(myRun.runnableB);
        b.start();
        Thread a = new Thread(myRun.runnableA);
        a.start();
    }
}

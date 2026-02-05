package com.example.lcj.thread.T3190NotifyErly;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/10 21:04
 */
public class MyRun02 {
    private String lock = new String("");
    private boolean isFirstRunB = false;
    private Runnable runnableA = new Runnable() {
        @Override
        public void run() {
            try {
                synchronized (lock) {
                    while (isFirstRunB == false) {
                        System.out.println("begin wait");
                        lock.wait();
                        System.out.println("end wait");
                    }
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

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                isFirstRunB = true;
                lock.notify();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("isFirstRunB true");
        }
    };

    public static void main(String[] args) {
        MyRun02 myRun = new MyRun02();
        Thread a = new Thread(myRun.runnableA);
        a.start();
        Thread b = new Thread(myRun.runnableB);
        b.start();
    }
}

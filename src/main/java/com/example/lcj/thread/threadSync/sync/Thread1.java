package com.example.lcj.thread.threadSync.sync;

public class Thread1 implements Runnable {

    private int baoZi = 1;

    private String threadName;

    public Thread1(String threadName) {
        super();
        this.threadName = threadName;
    }

    @Override
    /**
     * 同步块
     */
    public void run() {
//        synchronized(this){
        while (baoZi <= 10) {
            System.out.println(Thread.currentThread().getName() + " 吃第" + baoZi + "个包子a");
            baoZi++;
        }
//        }
    }


    public static void main(String[] args) {
        Thread1 t1 = new Thread1("超级张三线程");
        Thread t11 = new Thread(t1, "A");
        Thread t12 = new Thread(t1, "B");
        t11.start();
        t12.start();
    }

}
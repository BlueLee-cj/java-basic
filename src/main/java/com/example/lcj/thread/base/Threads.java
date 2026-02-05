package com.example.lcj.thread.base;

public class Threads implements Runnable {

    private static volatile int baoZi = 1;

    private String threadName;

    public Threads(String threadName) {
        super();
        this.threadName = threadName;
    }

    @Override
    public synchronized void run() {
        while (baoZi <= 10) {
            System.out.println(threadName + " 吃" + baoZi + "第个包子");
            baoZi++;
        }
    }

    public static void main(String[] args) {
        Threads t1 = new Threads("张三线程");
        Thread t11 = new Thread(t1);
        t11.start();


        Threads t2 = new Threads("李四线程");
        Thread t21 = new Thread(t2);
        t21.start();
    }

}

package com.example.lcj.thread;

/*
 *isAlive()
 * start
 */
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate---begin");

        System.out.println("Thread.currentThread().getName()="
                + Thread.currentThread().getName());        // main
        System.out.println("Thread.currentThread().isAlive()="
                + Thread.currentThread().isAlive());        // true

        System.out.println("this.getName()=" + this.getName());         // Thread-0
        System.out.println("this.isAlive()=" + this.isAlive());         // false

        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");

        System.out.println("Thread.currentThread().getName()="
                + Thread.currentThread().getName());        // A
        System.out.println("Thread.currentThread().isAlive()="
                + Thread.currentThread().isAlive());        // true

        System.out.println("this.getName()=" + this.getName());     // Thread-0
        System.out.println("this.isAlive()=" + this.isAlive());     // true

        System.out.println("run---end");
    }

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());        // false
        t1.setName("A");
        t1.start();
        c.start();
        System.out.println("main end t1 isAlive=" + t1.isAlive());      // true
    }
}
package com.example.lcj.thread;

public class MyThreadPriorityTest extends Thread {
    @Override
    public void run() {
        System.out.println("MyThreadPriorityTest run priority=" + this.getPriority());
        MyThreadPriority thread2 = new MyThreadPriority();
        thread2.start();
    }

    public static void main(String[] args) {
        System.out.println("main thread begin priority="
                + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end   priority="
                + Thread.currentThread().getPriority());
        MyThreadPriorityTest thread1 = new MyThreadPriorityTest();
        thread1.start();
    }
}

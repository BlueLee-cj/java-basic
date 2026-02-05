package com.example.lcj.thread;

public class MyThreadTest {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        MyThread myThread = new MyThread();
        myThread.start();
//		myThread.wait();
//		myThread.notify();
        System.out.println("���н���");
    }

}

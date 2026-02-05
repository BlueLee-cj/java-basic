package com.example.lcj.thread.T03currentthreadmethod;

public class SimpleCurrentThread extends Thread {

    public SimpleCurrentThread() {
        System.out.println("构造"
                + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run打印"
                + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        SimpleCurrentThread c = new SimpleCurrentThread();
        c.start();
    }
}
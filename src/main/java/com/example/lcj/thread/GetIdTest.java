package com.example.lcj.thread;

public class GetIdTest {
    public static void main(String[] args) {
        Thread runThread = Thread.currentThread();
        System.out.println(runThread.getName() + " " + runThread.getId());
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId());
            }
        }).start();
    }
}

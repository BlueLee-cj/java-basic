package com.example.lcj.thread;

public class MyRunnableTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("���н���");
    }

}

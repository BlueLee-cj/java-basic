package com.example.lcj.thread;

public class MyThread3 extends Thread {
    private int i;


    public MyThread3(int i) {
        super();
        this.i = i;
    }


    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        System.out.println(Thread.currentThread().getName() + "  " + i);
    }
}

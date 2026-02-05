package com.example.lcj.thread.T02share;

public class MyThreadNotShareTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyThreadNotShare a = new MyThreadNotShare("A");
        MyThreadNotShare b = new MyThreadNotShare("B");
        MyThreadNotShare c = new MyThreadNotShare("C");
        a.start();
        b.start();
        c.start();
    }

}

package com.example.lcj.thread;

public class MyThread3Test {
    public static void main(String[] args) {
        MyThread3 myThread3a = new MyThread3(1);
        MyThread3 myThread3b = new MyThread3(2);
        MyThread3 myThread3c = new MyThread3(3);
        MyThread3 myThread3d = new MyThread3(4);
        MyThread3 myThread3e = new MyThread3(5);
        MyThread3 myThread3f = new MyThread3(6);
        MyThread3 myThread3g = new MyThread3(7);
        MyThread3 myThread3h = new MyThread3(8);
        MyThread3 myThread3l = new MyThread3(9);
        myThread3a.start();
        myThread3b.start();
        myThread3c.start();
        myThread3d.start();
        myThread3e.start();
        myThread3f.start();
        myThread3g.start();
        myThread3h.start();
        myThread3l.start();
        System.out.println(Thread.currentThread().getName());
    }
}

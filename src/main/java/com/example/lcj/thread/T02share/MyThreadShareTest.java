package com.example.lcj.thread.T02share;

public class MyThreadShareTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //非线程安全主要指的是多个线程对同一个对象中的同一个实例变量进行操作时，会出现值被更改、值不同步的情况。
        MyThreadShare myThreadShare = new MyThreadShare();
        Thread a = new Thread(myThreadShare, "A");
        Thread b = new Thread(myThreadShare, "B");
        Thread c = new Thread(myThreadShare, "C");
        Thread d = new Thread(myThreadShare, "D");
        Thread e = new Thread(myThreadShare, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

}
 
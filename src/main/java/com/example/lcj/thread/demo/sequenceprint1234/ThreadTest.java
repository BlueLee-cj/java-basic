package com.example.lcj.thread.demo.sequenceprint1234;

import java.util.ArrayList;

public class ThreadTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //1、先创建一个LockObject对象
        LockObject lobject = new LockObject(0);

        //2、创建10个线程的数组
        MyThread1[] mythread = new MyThread1[10];
        //初始化线程并且启动，
        //为了证明线程琐的作用，线程从后面开始启动
        for (int i = 0; i < 10; i++) {
            mythread[i] = new MyThread1(lobject, 9 - i);
            //启动线程  注意继承Thread类是调用start方法，实现Runable接口是调用run方法
            mythread[i].start();
        }


    }

}

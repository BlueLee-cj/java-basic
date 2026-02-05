package com.example.lcj.thread.T214SynchronizedAndLockObject;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:30
 */
public class Run {
    public static void main(String[] args) {
        //调用关键字synchronized声明的方法一定时排队运行的
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}

package com.example.lcj.thread.T214SynchronizedAndLockObject.SameObjectDifferentSychMethod;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:30
 */
public class Run {
    public static void main(String[] args) {
        //调用关键字synchronized声明的方法一定时排队运行的
        //1、A线程先持有object对象的Lock锁，B线程可以异步方式调用obeject对象的非sychronized类型的方法
        //2、A线程先持有object对象的Lock锁，B线程如果这时调用object对象中的sychronized类型的方法则需要等待，也就是同步
        MyObject object = new MyObject();
        ThreadA a = new ThreadA(object);
        a.setName("A");
        ThreadB b = new ThreadB(object);
        b.setName("B");
        a.start();
        b.start();
    }
}

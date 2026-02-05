package com.example.lcj.thread.T01threadOrRunnble;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/17 9:03
 * 就我个人意见，我更倾向于实现Runnable接口这种方法。
 * 因为线程池可以有效的管理实现了Runnable接口的线程，
 * 如果线程池满了，新的线程就会排队等候执行，直到线程池空闲出来为止。
 * 而如果线程是通过实现Thread子类实现的，这将会复杂一些。
 */
public class Tester {
    public static void main(String[] args) {
//        new Person("小A").start();
//        new Person("小B").start();
//        new Person("小C").start();

        Apple apple = new Apple();
        new Thread(apple, "小A").start();
        new Thread(apple, "小B").start();
        new Thread(apple, "小C").start();
    }
}

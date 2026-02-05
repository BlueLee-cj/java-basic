package com.example.lcj.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/25 12:47
 */
public class ThreadLocal2 {
    static ThreadLocal<Person> tl = new ThreadLocal<Person>();

    static class Person {
        String name = "zhangsan";
    }

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tl.get());
        }).start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tl.set(new Person());
            System.out.println(tl.get());
        }).start();
    }
}

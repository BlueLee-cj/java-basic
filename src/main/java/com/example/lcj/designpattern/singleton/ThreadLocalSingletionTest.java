package com.example.lcj.designpattern.singleton;

/**
 * @author lichengjian
 * @date 2021/3/13
 */
public class ThreadLocalSingletionTest {
    public static void main(String[] args) {
        System.out.println(ThreadLocalSingletion.getInstance());
        System.out.println(ThreadLocalSingletion.getInstance());
        System.out.println(ThreadLocalSingletion.getInstance());
        System.out.println(ThreadLocalSingletion.getInstance());

        Thread t1 = new Thread(new ExectorThreadSingletion());
        t1.start();
        Thread t2 = new Thread(new ExectorThreadSingletion());
        t2.start();
        System.out.println("end");
    }
}

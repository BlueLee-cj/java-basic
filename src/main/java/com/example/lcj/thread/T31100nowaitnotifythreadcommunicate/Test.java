package com.example.lcj.thread.T31100nowaitnotifythreadcommunicate;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/5 22:53
 */
public class Test {
    public static void main(String[] args) {
        MyList service = new MyList();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
    }
}

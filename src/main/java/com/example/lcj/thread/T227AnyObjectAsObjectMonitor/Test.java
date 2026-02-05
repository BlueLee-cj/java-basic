package com.example.lcj.thread.T227AnyObjectAsObjectMonitor;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 10:01
 */
public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(service);
        b.setName("b");
        b.start();
    }
}

package com.example.lcj.thread.T2370SyncIsVolitatileProperty;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 10:01
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        a.start();
        Thread.sleep(1000);
        ThreadAB b = new ThreadAB(service);
        b.start();
        System.out.println("已经发起停止的命令了");
    }
}

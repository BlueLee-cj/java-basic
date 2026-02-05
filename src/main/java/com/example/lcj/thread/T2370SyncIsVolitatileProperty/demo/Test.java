package com.example.lcj.thread.T2370SyncIsVolitatileProperty.demo;

/**
 * @author ：lcj
 * @description：同步synchronized不仅可以解决一个线程看到对象处于不一致的状态，还可以保证 进入同步方法或同步代码块的每个线程，都看到由同一个锁保护之前所有的修改效果
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

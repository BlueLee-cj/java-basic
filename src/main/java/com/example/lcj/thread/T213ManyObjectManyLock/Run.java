package com.example.lcj.thread.T213ManyObjectManyLock;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:30
 */
public class Run {
    public static void main(String[] args) {
        //多线程访问多个对象，则JVM会创建多个锁
        HasSelfPrivateNum hasSelfPrivateNum1 = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(hasSelfPrivateNum1);
        a.start();
        ThreadB b = new ThreadB(hasSelfPrivateNum2);
        b.start();
    }
}

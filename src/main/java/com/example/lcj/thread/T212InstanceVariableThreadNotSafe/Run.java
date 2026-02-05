package com.example.lcj.thread.T212InstanceVariableThreadNotSafe;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:30
 */
public class Run {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(hasSelfPrivateNum);
        a.start();
        ThreadB b = new ThreadB(hasSelfPrivateNum);
        b.start();
    }
}

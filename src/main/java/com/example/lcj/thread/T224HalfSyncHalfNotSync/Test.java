package com.example.lcj.thread.T224HalfSyncHalfNotSync;


/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 10:01
 */
public class Test {
    public static void main(String[] args) {
        Task task = new Task();
        ThreadA a = new ThreadA(task);
        a.start();
        ThreadB b = new ThreadB(task);
        b.start();
    }
}

package com.example.lcj.thread.T04isalive;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/9 9:01
 */
public class Run {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread t = new Thread(countOperate);
        System.out.println("main begin t islive=" + t.isAlive());
        t.setName("A");
        t.start();
        System.out.println("main end t isalive=" + t.isAlive());
    }
}

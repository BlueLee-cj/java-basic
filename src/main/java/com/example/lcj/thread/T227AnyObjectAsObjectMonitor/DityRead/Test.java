package com.example.lcj.thread.T227AnyObjectAsObjectMonitor.DityRead;

import com.example.lcj.thread.T227AnyObjectAsObjectMonitor.Service;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 10:01
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        MyOneList list = new MyOneList();
        ThreadA a = new ThreadA(list);
        a.setName("a");
        a.start();
//        Thread.sleep(2000);
        ThreadB b = new ThreadB(list);
        b.setName("b");
        b.start();
        Thread.sleep(3000);
        System.out.println("lsitSize = " + list.getSize());
    }
}

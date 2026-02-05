package com.example.lcj.thread.T01threadOrRunnble;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/17 8:59
 */
public class Person extends Thread {
    private int num = 50;

    public Person(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (num > 0) {
                System.out.println(super.getName() + "吃了编号为：" + num-- + "的苹果");
            }
        }
    }
}

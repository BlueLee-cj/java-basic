package com.example.lcj.thread.T3110WaitConditionChange;


/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:48
 */
public class Add {
    private String lock;

    public Add(String lock) {
        this.lock = lock;
    }

    public void add() {
        synchronized (lock) {
            ValueObject.list.add("anything");
            lock.notifyAll();
        }
    }
}

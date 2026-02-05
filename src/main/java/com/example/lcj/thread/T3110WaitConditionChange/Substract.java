package com.example.lcj.thread.T3110WaitConditionChange;


/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:50
 */
public class Substract {
    private String lock;

    public Substract(String lock) {
        this.lock = lock;
    }

    public void substract() {
        try {
            synchronized (lock) {
                if (ValueObject.list.size() == 0) {
                    System.out.println("wait begin ThreadName = " + Thread.currentThread().getName());
                    lock.wait();
                    System.out.println("wait end ThreadName = " + Thread.currentThread().getName());
                }
//                while (ValueObject.list.size() == 0){
//                    System.out.println("wait begin ThreadName = " + Thread.currentThread().getName());
//                    lock.wait();
//                    System.out.println("wait end rThreadName = " + Thread.currentThread().getName());
//                }
                ValueObject.list.remove(0);
                System.out.println("list size = " + ValueObject.list.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

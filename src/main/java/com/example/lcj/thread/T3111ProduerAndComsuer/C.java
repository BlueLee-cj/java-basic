package com.example.lcj.thread.T3111ProduerAndComsuer;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/10 21:36
 */
public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get 值是 " + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

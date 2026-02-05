package com.example.lcj.thread.T3110WaitConditionChange;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/6 21:57
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        Substract substract = new Substract(lock);
        ThreadSun threadSun = new ThreadSun(substract);
        threadSun.setName("substract1Thread");
        threadSun.start();
        ThreadSun thread2Sun = new ThreadSun(substract);
        thread2Sun.setName("substract2Thread");
        thread2Sun.start();
        Thread.sleep(1000);
        Add add = new Add(lock);
        ThreadAdd threadAdd = new ThreadAdd(add);
        threadAdd.setName("addThread");
        threadAdd.start();
    }
}

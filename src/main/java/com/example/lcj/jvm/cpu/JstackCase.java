package com.example.lcj.jvm.cpu;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/12/3 14:41
 */
public class JstackCase {
    static  ExecutorService threadPool = Executors.newFixedThreadPool(5);
    public static Object lock = new Object();

    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        threadPool.execute(task1);
        threadPool.execute(task2);
    }

    //static class  Task implements Runnable {
    //
    //    @Override
    //    public void run() {
    //        synchronized (lock) {
    //            calculate();
    //        }
    //    }
    //    public void calculate() {
    //        int i = 0;
    //        while (true) {
    //            i++;
    //        }
    //    }
    //}
    static class  Task implements Runnable {

        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package com.example.lcj.thread.juc.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/14 14:47
 */
public class ExchangerTest {
    private static final Exchanger<String> exg = new Exchanger<String>();

    private static final int THREADS_COUNT = 2;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREADS_COUNT);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    exg.exchange(A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";
                    String A = exg.exchange("A");
                    System.out.println("银行流水是否一致: " + A.equals(B) + " A的数据是：" + A);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadPool.shutdown();
    }

}

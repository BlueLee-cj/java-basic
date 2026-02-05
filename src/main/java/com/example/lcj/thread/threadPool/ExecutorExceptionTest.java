package com.example.lcj.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/6/5 23:10
 */
public class ExecutorExceptionTest {
    public static void main(String[] args) {
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //for (int i = 0; i < 5; i++) {
        //    Future future = threadPool.submit(() -> {
        //        System.out.println("current thread name" + Thread.currentThread().getName());
        //        Object object = null;
        //        System.out.println("result## " + object.toString());
        //    });
        //    try {
        //        future.get();
        //    }catch (Exception e){
        //        System.out.println("异常了");
        //    }
        //}


        //ExecutorService threadPool1 = Executors.newFixedThreadPool(1, r -> {
        //    Thread t = new Thread(r);
        //    t.setUncaughtExceptionHandler(
        //            (t1, e) -> {
        //                System.out.println(t1.getName() + "线程抛出的异常"+e);
        //            });
        //    return t;
        //});
        //threadPool1.execute(()->{
        //    Object object = null;
        //    System.out.print("result## " + object.toString());
        //});

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    //do nothing
                }
            });
        }
    }
}


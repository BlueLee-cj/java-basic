package com.example.lcj.thread.threadPool;

import java.util.concurrent.*;

public class MainTest {

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("execute");
            }
        });

        Future<?> submit = pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("submit");
            }
        });
        // 等任务执行完毕会打印null
        System.out.println(submit.get());

        FutureTask<Integer> submit2 = (FutureTask<Integer>) pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("submit_2");
                return 2;
            }
        });
        System.out.println("result=" + submit2.get());
    }

}

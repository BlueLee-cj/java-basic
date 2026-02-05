package com.example.lcj.thread.threadPool.future;

import java.util.concurrent.*;

/**
 * 测试方法的超时时间
 */
public class FutureTest1 {

    public static void functionTimeoutTest() throws Exception {
        // java8建议使用lambda表达式来替代匿名内部类
        Callable<String> task = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "success";
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(task);
        try {
            String result = future.get(5, TimeUnit.SECONDS);
            // String result=future.get(50,TimeUnit.SECONDS);
            System.out.println("result:" + result);
        } catch (TimeoutException e) {
            System.out.println("超时了!");
        }
    }

    public static void functionTimeoutTest3() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        FutureTask<String> future = new FutureTask<>(() -> {
            Thread.sleep(10000);
            return "success";
        });
        executorService.execute(future);

        try {
            String result = future.get(5, TimeUnit.SECONDS);
            // String result=future.get(50,TimeUnit.SECONDS);
            System.out.println("result:" + result);
        } catch (TimeoutException e) {
            System.out.println("超时了!");
        }
    }
}

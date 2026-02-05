package com.example.lcj.thread.threadPool.future;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * 测试方法的超时时间
 */
public class FutureTest {
    public static void main(String[] args) throws Exception {
        // functionTimeoutTest2();


        futureTest2();
    }

    public static void functionTimeoutTest2() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            throw new RuntimeException("异常了11");
        });
        Future<String> future = executorService.submit(() -> {
            // Thread.sleep(10000);

            throw new RuntimeException("异常了222");
        });

        try {
            // String result = future.get(5, TimeUnit.SECONDS);
            String result = future.get(50, TimeUnit.SECONDS);
            System.out.println("result:" + result);
        } catch (TimeoutException e) {
            e.printStackTrace();

        }

        System.out.println("我先走一步拉");
    }


    /**
     * 从字面意思理解就是未来的意思，但使用起来却着实有点鸡肋，并不能实现真正意义上的异步，获取结果时需要阻塞线程，或者不断轮询。
     * @throws Exception
     */
    public static void futureTest() throws Exception {

        System.out.println("main函数开始执行");

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(() -> {

            System.out.println("===task start===");
            Thread.sleep(5000);
            System.out.println("===task finish===");
            return 3;
        });
        // 这里需要返回值时会阻塞主线程，如果不需要返回值使用是OK的。倒也还能接收
         Integer result=future.get();
        System.out.println("main函数执行结束");

        System.in.read();

    }


    public static void futureTest2() throws IOException, ExecutionException, InterruptedException {

        System.out.println("main函数开始执行");

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                System.out.println("===task start===");
                Thread.sleep(5000);
                System.out.println("===task finish===");
                return 3;
            }
        });
        //这里需要返回值时会阻塞主线程，如果不需要返回值使用是OK的。倒也还能接收
        Integer result=future.get();
        System.out.println("main函数执行结束");

        System.in.read();
    }
}


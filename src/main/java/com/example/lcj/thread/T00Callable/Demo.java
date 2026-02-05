package com.example.lcj.thread.T00Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ：lcj
 * @description：实际的开发中，我们经常要创建子线程来做一些耗时任务，然后把任务执行结果回传给主线程使用，这种情况在 Java 里要如何实现呢？
 * 举例，我们想让子线程去计算从 1 加到 100，并把算出的结果返回到主线程
 * 可以看到，主线程调用 futureTask.get() 方法时阻塞主线程；然后 Callable 内部开始执行，并返回运算结果；
 * 此时 futureTask.get() 得到结果，主线程恢复运行。
 * @date ：Created in 2019/10/11 11:38
 */
public class Demo {
    public static void main(String[] args) {
        doTaskWithResultInWorker();
    }

    private static void doTaskWithResultInWorker() {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("Task starts");
                Thread.sleep(1000);
                int result = 0;
                for (int i = 0; i <= 100; i++) {
                    result += i;
                }
                System.out.println("Task finished and return result");
                return result;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        try {
            System.out.println("Before futureTask.get()");
            System.out.println("Result: " + futureTask.get());
            System.out.println("After futureTask.get()");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

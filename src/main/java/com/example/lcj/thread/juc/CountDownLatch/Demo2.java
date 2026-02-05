package com.example.lcj.thread.juc.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 场景2 让单个线程等待：多个线程(任务)完成后，进行汇总合并
 * 很多时候，我们的并发任务，存在前后依赖关系；比如数据详情页需要同时调用多个接口获取数据，并发请求获取到数据后、需要进行结果合并；或者多个数据操作完成后，需要数据check；
 * 这其实都是：在多个线程(任务)完成后，进行汇总合并的场景。
 * 
 * 在每个线程(任务) 完成的最后一行加上CountDownLatch.countDown()，让计数器-1；
 * 当所有线程完成-1，计数器减到0后，主线程往下执行汇总任务。
 *
 * 从上面两个例子的代码，可以看出 CountDownLatch 的API并不多；
 *
 * CountDownLatch的构造函数中的count就是闭锁需要等待的线程数量。这个值只能被设置一次，而且不能重新设置；
 * await()：调用该方法的线程会被阻塞，直到构造方法传入的 N 减到 0 的时候，才能继续往下执行；
 * countDown()：使 CountDownLatch 计数值 减 1；
 * 
 * @author lichengjian
 * @date 2021/4/14
 */
public class Demo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            final int index = i;
            new Thread(() -> {
                try {
                    Thread.sleep(1000 + ThreadLocalRandom.current().nextInt(1000));
                    System.out.println("finish" + index + Thread.currentThread().getName());
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        countDownLatch.await();// 主线程在阻塞，当计数器==0，就唤醒主线程往下执行。
        System.out.println("主线程:在所有任务运行完成后，进行结果汇总");
    }
}

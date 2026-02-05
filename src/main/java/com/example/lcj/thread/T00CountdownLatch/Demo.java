package com.example.lcj.thread.T00CountdownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author ：lcj
 * @description： 四个线程 A B C D，其中 D 要等到 A B C 全执行完毕后才执行，而且 A B C 是同步运行的
 * 最开始我们介绍了 thread.join()，可以让一个线程等另一个线程运行完毕后再继续执行，那我们可以在 D 线程里依次 join A B C，不过这也就使得 A B C 必须依次执行，而我们要的是这三者能同步运行。
 * 或者说，我们希望达到的目的是：A B C 三个线程同时运行，各自独立运行完后通知 D；对 D 而言，只要 A B C 都运行完了，D 再开始运行。针对这种情况，我们可以利用 CountdownLatch 来实现这类通信方式。它的基本用法是：
 * <p>
 * 1、创建一个计数器，设置初始值，CountdownLatch countDownLatch = new CountDownLatch(2);
 * 2、在 等待线程 里调用 countDownLatch.await() 方法，进入等待状态，直到计数值变成 0；
 * 3、在 其他线程 里，调用 countDownLatch.countDown() 方法，该方法会将计数值减小 1；
 * 4、当 其他线程 的 countDown() 方法把计数值变成 0 时，等待线程 里的 countDownLatch.await() 立即退出，继续执行下面的代码。
 * 其实简单点来说，CountDownLatch 就是一个倒计数器，我们把初始计数值设置为3，
 * 当 D 运行时，先调用 countDownLatch.await() 检查计数器值是否为 0，若不为 0 则保持等待状态；
 * 当A B C 各自运行完后都会利用countDownLatch.countDown()，将倒计数器减 1，当三个都运行完后，计数器被减至 0；
 * 此时立即触发 D 的 await() 运行结束，继续向下执行。
 * @date ：Created in 2019/10/11 11:27
 */
public class Demo {
    public static void main(String[] args) {
        runDAfterABC();
    }

    private static void runDAfterABC() {
        int worker = 3;
        CountDownLatch countDownLatch = new CountDownLatch(worker);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("D is waiting for other three threads");
                try {
                    countDownLatch.await();
                    System.out.println("All done, D starts working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        for (char threadName = 'A'; threadName <= 'C'; threadName++) {
            final String tN = String.valueOf(threadName);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(tN + " is working");
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(tN + " finished");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}

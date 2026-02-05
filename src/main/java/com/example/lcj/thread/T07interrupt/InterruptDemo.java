package com.example.lcj.thread.T07interrupt;

/**
 * 本示例新建了一个线程，用主线程启动，主线程睡1s，再调用子线程的interrupt()方法，子线程由于也在睡着，被打断后，输出子线程中断状态。
 * 这里子线程的isInterrupted()方法返回是false，讲道理的话，应该返回的是true才对，因为子线程确实被中断了。Thread.sleep源码注释：
 * if any thread hashConstruct interrupted the current thread. The <i>interrupted status</i> of the current thread is cleared when this exception is thrown.
 * 意思是，如果任何一个线程打断了当前线程，当InterruptedException异常抛出时，那么当前线程的”中断状态“就被清除了。
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {

            System.out.println(Thread.currentThread().getName() + " start...");

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " into catch");
                System.out.println("isInterrupted: " + Thread.currentThread().isInterrupted());
            }

            System.out.println(Thread.currentThread().getName() + " end...");

        });

        t.start();
        Thread.sleep(1000);

        t.interrupt();

        System.out.println("Main thread end...");

    }

}
package com.example.lcj.thread.T12join;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/10/11 11:21
 */
public class JoinDemo {
    public static void main(String[] args) {
        //demo1();
        demo2();
    }

    private static void demo1() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("B");
            }
        });
        A.start();
        B.start();
    }

    private static void demo2() {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                printNumber("A");
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("B 开始等待 A");
                try {
                    A.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printNumber("B");
            }
        });
        B.start();
        A.start();
    }

    private static void printNumber(String threadName) {
        int i = 0;
        while (i++ < 3) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + " print: " + i);
        }
    }
}

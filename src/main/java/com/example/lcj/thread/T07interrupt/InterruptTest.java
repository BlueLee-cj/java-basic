package com.example.lcj.thread.T07interrupt;

public class InterruptTest {

    public static void main1(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName()+" 依旧在运行");
                }
            }
        });

        thread.start();
        // 执行线程的interrupt()方法
        thread.interrupt();
    }

    /**
     * 可以看到，调用某一个线程对象的isInterrupted()方法会返回该线程的中断状态码。
     * 调用interrupt()方法以后，会改变这个线程的中断状态码。
     * @param args
     */
    public static void main2(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                }
            }
        });

        thread.start();
        System.out.println(thread.isInterrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }

    /**
     * 这个方法会返回当前线程的中断标志位，同时会重置中断标志位。
     * @param args
     */
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (true) {
                    if (Thread.interrupted()) {
                        System.err.println("线程中断标志位为true");
                    }
                }
            }
        });
        System.out.println(thread.isInterrupted());
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
    /**
     * 可以看出：
     *
     * 该方法是一个Thread类的静态方法，调用时会返回当前线程的中断状态码。
     * 调用完该方法以后，中断状态码会被重置。
     */




    /**
     * 第一个红框中断的线程是我们自己创建的myThread线程，我调用的interrupted()，
     * 由上面源码可知是判断当前线程的中断状态，当前线程是main线程，我根本没有中断过main线程，所以2次调用均返回“false”
     * @param args
     */
    public static void main4(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("线程中断标志位为true");
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("第一调用返回值："  + Thread.interrupted());
        System.out.println("第二调用返回值："  + Thread.interrupted());
    }


    /**
     * 第一个红框中断的线程是当前线程（main线程），我调用的interrupted()，
     * 由上面源码可知是判断当前线程的中断状态，当前线程是main线程，所以第1次调用结果返回“true”，因为我确实中断了main线程，
     * @param args
     */
    public static void main5(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("线程中断标志位为true");
            }
        });
        thread.start();
        thread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("第一调用返回值："  + Thread.interrupted());
        /**
         * 由源码可知interrupted()调用的是isInterrupted()，并会重置中断状态，
         * 所以第一次调用之后把中断状态给重置了，从中断状态重置为非中断状态，所以第2次调用的结果返回“false”
         */
        System.out.println("第二调用返回值："  + Thread.interrupted());
    }


    /**
     * 第一个红框中断的线程是我们自己创建的myThread线程，我调用的isInterrupted()，
     * 由上面源码可知是判断执行该方法的对象所表示线程的中断状态，也就是myThread引用所表示的线程的中断状态，所以第1次调用结果返回“true”
     * @param args
     */
    public static void main6(String[] args) {
        Thread mythread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("线程中断标志位为true");
            }
        });
        mythread.start();
        mythread.interrupt();
        System.out.println("第一调用返回值："  + mythread.isInterrupted());
        /**
         * 由源码可知isInterrupted()不会重置中断状态，
         * 所以第一次调用之后没有把中断状态给重置（从中断状态重置为非中断状态），所以第2次调用的结果还返回“true
         */
        System.out.println("第二调用返回值："  + mythread.isInterrupted());
    }



    /**
     * 第一个红框中断的线程是我们自己创建的myThread线程，我调用的isInterrupted()，
     * 由上面源码可知是判断执行该方法的对象所表示线程的中断状态，也就是main的中断状态，我压根没有中断main线程，所以理所当然2次调用结果都返回“false”
     * @param args
     */
    public static void main8(String[] args) {
        Thread mythread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("线程中断标志位为true");
            }
        });
        mythread.start();
        mythread.interrupt();
        System.out.println("第一调用返回值："  + Thread.currentThread().isInterrupted());
        System.out.println("第二调用返回值："  + Thread.currentThread().isInterrupted());
    }


    /**
     * 第一个红框中断的线程是当前线程（main线程），我调用的isInterrupted()，
     * 由上面源码可知是判断执行该方法的对象所表示线程的中断状态，也就是main的中断状态，所以第1次调用结果返回“true”,
     * @param args
     */
    public static void main9(String[] args) {
        Thread mythread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("线程中断标志位为true");
            }
        });
        mythread.start();
        Thread.currentThread().interrupt();
        System.out.println("第一调用返回值："  + Thread.currentThread().isInterrupted());
        System.out.println("第二调用返回值："  + Thread.currentThread().isInterrupted());
    }

}
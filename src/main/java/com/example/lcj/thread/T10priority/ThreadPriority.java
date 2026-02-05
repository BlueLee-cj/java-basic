package com.example.lcj.thread.T10priority;

class ThreadPriority implements Runnable {
    private String name;

    public ThreadPriority(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
        }

    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadPriority("C"));
        Thread t2 = new Thread(new ThreadPriority("D"));
        //CPU尽量将执行资源让给优先级比较高的线程
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
        System.out.println("运行  :  " + Thread.currentThread().getName());
    }

}
 

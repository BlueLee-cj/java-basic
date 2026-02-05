package com.example.lcj.thread.T05sleep;

/**
 * 归根结底是因为没有任何操作来限制线程来获取相同的资源并对他们进行操作，这就造成了线程安全性问题
 */
class ThreadSleep implements Runnable {
    private int num = 50;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            if (num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "吃了编号为：" + num + "的苹果");
                num--;
            }
        }
    }


    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();
        new Thread(threadSleep, "A").start();
        new Thread(threadSleep, "B").start();
        new Thread(threadSleep, "C").start();
    }

}
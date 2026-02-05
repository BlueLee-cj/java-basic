package com.example.lcj.thread.synctypesample;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/17 14:12
 */
public class Machine implements Runnable {
    private int a = 1;//共享数据

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (this) {
                a += i;
                try {
                    Thread.sleep(10);//给其他线程运行的机会
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                a -= i;
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }

    public void go() {
        for (int i = 0; i < 100; i++) {
            //i是局部变量
            System.out.println(Thread.currentThread().getName() + ":" + i);
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        Thread thread1 = new Thread(machine);
        Thread thread2 = new Thread(machine);
        thread1.start();
        thread2.start();
        machine.go();
    }
}

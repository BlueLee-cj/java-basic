package com.example.lcj.thread.T31100nowaitnotifythreadcommunicate;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/5 22:46
 */
public class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                list.add();
                System.out.println("添加了" + (i + 1) + "个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.example.lcj.thread.T31100nowaitnotifythreadcommunicate;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/5 22:46
 */
public class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 5) {
                    System.out.println("==5了线程b要退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

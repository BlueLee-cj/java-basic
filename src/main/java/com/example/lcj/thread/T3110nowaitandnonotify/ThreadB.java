package com.example.lcj.thread.T3110nowaitandnonotify;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/9 21:38
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
                    System.out.println("==5 线程b要退出了");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

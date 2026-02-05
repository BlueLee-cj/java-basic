package com.example.lcj.thread.T11shouhuThread;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:10
 * 任何一个守护线程都是整个JVM中所有非守护线程的保姆，只有当前jvm实例中存在
 * 任何一个非守护线程没有结束，守护线程就在工作，只有最后一个非守护线程结束时，守护线程才随着JVM一同结束工作
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("停止不打印了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

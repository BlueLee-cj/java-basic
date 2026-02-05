package com.example.lcj.thread.T08suspendorresume;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 16:07
 */
public class duzhan extends Thread {
    private long i = 0;

    @Override
    public void run() {
        while (i < 100) {
            i++;
            //当程序运行到println（）方法内部停止，同步锁未被释放，处于暂停状态，main中迟迟无法打印
            System.out.println(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        duzhan duzhan = new duzhan();
        duzhan.start();
        Thread.sleep(1000);
//        duzhan.suspend();
        Thread.sleep(5000);
//        duzhan.resume();
        System.out.println("main end ");

    }
}

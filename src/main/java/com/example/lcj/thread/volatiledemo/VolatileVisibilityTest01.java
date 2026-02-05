package com.example.lcj.thread.volatiledemo;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/19 21:24
 */
public class VolatileVisibilityTest01 {
    private static volatile boolean initFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("========等待数据准备。。。");
                while (!initFlag) {
                }
                System.out.println("========数据准备完毕，执行程序逻辑");
            }
        }).start();

        Thread.sleep(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                prepareData();
            }
        }).start();
    }

    private static void prepareData() {
        System.out.println("准备修改数据。。。");
        initFlag = true;
        System.out.println("数据修改完毕");

    }
}

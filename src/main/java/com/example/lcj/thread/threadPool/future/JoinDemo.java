package com.example.lcj.thread.threadPool.future;

import org.springframework.util.StopWatch;

/**
 * Created by 尼恩 at 疯狂创客圈
 */

public class JoinDemo {

    public static final int SLEEP_GAP = 500;

    public static final int SLEEP_GAP2 = 1500;

    public static String getCurThreadName() {
        return Thread.currentThread().getName();
    }

    static class HotWarterThread extends Thread {


        HotWarterThread() {
            super("** 烧水-Thread");
        }

        @Override
        public void run() {

            try {
                System.out.println("洗好水壶");
                System.out.println("灌上凉水");
                System.out.println("放在火上");

                // 线程睡眠一段时间，代表烧水中
                Thread.sleep(SLEEP_GAP2);
                System.out.println("水开了");

            } catch (InterruptedException e) {
                System.out.println(" 发生异常被中断.");
            }
            System.out.println(" 运行结束.烧水");
        }

    }

    static class WashThread extends Thread {


        WashThread() {
            super("$$ 清洗-Thread");
        }

        @Override
        public void run() {

            try {
                System.out.println("洗茶壶");
                System.out.println("洗茶杯");
                System.out.println("拿茶叶");
                // 线程睡眠一段时间，代表清洗中
                Thread.sleep(SLEEP_GAP);
                System.out.println("洗完了");

            } catch (InterruptedException e) {
                System.out.println(" 发生异常被中断.");
            }
            System.out.println(" 运行结束.清洗");
        }

    }


    public static void main(String[] args) {

        Thread hThread = new HotWarterThread();
        Thread wThread = new WashThread();

        hThread.start();
        wThread.start();
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            // 合并烧水-线程
            hThread.join();
            // 合并清洗-线程
            wThread.join();

            Thread.currentThread().setName("主线程");
            stopWatch.stop();
            System.out.println("泡茶喝" + stopWatch.getTotalTimeMillis());

        } catch (InterruptedException e) {
            System.out.println(getCurThreadName() + "发生异常被中断.");
        }

        System.out.println(getCurThreadName() + " 运行结束.");
    }
}

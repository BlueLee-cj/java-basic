package com.example.lcj.thread.juc.cyclicbarrier;

import java.time.LocalTime;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO CyclicBarrier 示例
 *
 * @author liuzebiao
 * @Date 2020-4-30 16:48
 */
public class CyclicBarrierDemo {

    /**
     * 线程
     */
    static class Worker implements Runnable{

        private CyclicBarrier barrier;
        //名称
        private String name;

        public Worker(CyclicBarrier barrier,String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            String[] arr = {"搬砖","吃饭","扫地"};
            try {
                for (int i = 0; i < 3; i++) {
                    int seconds = (int) (Math.random() * 10 + 1);//产生1到10之间的随机整数
                    TimeUnit.SECONDS.sleep(seconds);
                    System.out.println(name+","+arr[i]+"完成,时间:"+ LocalTime.now());
                    // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
                    barrier.await();
                    System.out.println(name+","+arr[i]+"结束等待,时间:"+ LocalTime.now());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个无界线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //创建一个 CyclicBarrier 对象,指定线程数为 3
        CyclicBarrier barrier = new CyclicBarrier(3);

        exec.execute(new Worker(barrier,"A"));
        exec.execute(new Worker(barrier,"B"));
        exec.execute(new Worker(barrier,"C"));


        System.out.println("##########开始执行主线程");
        System.out.println("执行11+12结果:"+(11+12));
        System.out.println("主线程执行完成");

        exec.shutdown();//关闭线程池(仅用作程序中断使用)

    }
}

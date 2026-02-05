package com.example.lcj.thread.juc.CountDownLatch.demo01;


import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO CountDownLatch 示例
 *
 * @author liuzebiao
 * @Date 2020-4-30 15:25
 */
public class CountDownLatchDemo {

    /**
     * 工人A
     */
    public static class WorkA extends Thread{

        private CountDownLatch latch;

        public WorkA(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            try {
                System.out.println("工人A准备搬砖,时间:"+ LocalDateTime.now());
                TimeUnit.SECONDS.sleep(5);
                System.out.println("工人A任务完成,用时5s,时间:"+ LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                //执行 countDown() 进行-1 操作,说明任务已完成
                latch.countDown();
            }
        }
    }

    /**
     * 工人B
     */
    public static class WorkB extends Thread{

        private CountDownLatch latch;

        public WorkB(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("工人B准备扫地,时间:"+ LocalDateTime.now());
                TimeUnit.SECONDS.sleep(20);
                System.out.println("工人B任务完成,用时20s,时间:"+ LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }

    /**
     * 工人C
     */
    public static class WorkC extends Thread{

        private CountDownLatch latch;

        public WorkC(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("工人C准备和泥,时间:"+ LocalDateTime.now());
                TimeUnit.SECONDS.sleep(30);
                System.out.println("工人C任务完成,用时30s,时间:"+ LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }
    }

    public static void main(String[] args) {
        //创建一个无界线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建一个 CountDownLatch 对象,指定计数器为 3
        CountDownLatch latch = new CountDownLatch(3);
        //创建3个任务(同一组线程中,需要使用同一个 CountDownLatch 对象)
        WorkA workA = new WorkA(latch);
        WorkB workB = new WorkB(latch);
        WorkC workC = new WorkC(latch);

        executorService.execute(workA);
        executorService.execute(workB);
        executorService.execute(workC);

        try {
            //执行 await() 阻塞
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("你个小样,干个活这么费劲,块走,一起汇报任务去,时间:"+ LocalDateTime.now());

        //关闭线程池任务
        executorService.shutdown();
    }
}


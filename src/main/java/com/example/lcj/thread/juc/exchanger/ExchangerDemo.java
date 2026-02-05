package com.example.lcj.thread.juc.exchanger;

import java.time.LocalTime;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * TODO Exchanger 示例
 *
 * @author liuzebiao
 * @Date 2020-5-6 14:10
 */
public class ExchangerDemo {

    /**
     * 定义内部线程类 ExchangerThread
     */
    static class ExchangeThread implements Runnable{
        //Exchanger对象
        private Exchanger<String> exchanger;
        //数据
        private String data;
        //传入同一个 Exchanger
        public ExchangeThread(Exchanger<String> exchanger, String data) {
            this.exchanger = exchanger;
            this.data = data;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + "线程,数据为:"+data +",当前时间:"+ LocalTime.now());
                String exchange = exchanger.exchange(data);
                System.out.println(Thread.currentThread().getName() + "线程,交换数据后,数据为:"+exchange +",当前时间:"+ LocalTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        Exchanger<String> exchanger = new Exchanger<>();

        //线程1
        ExchangeThread thread01 = new ExchangeThread(exchanger,"001");
        //线程2
        ExchangeThread thread02 = new ExchangeThread(exchanger,"002");
        //执行线程1
        executor.execute(thread01);
        //休眠5s
        TimeUnit.SECONDS.sleep(5);
        //执行线程2
        executor.execute(thread02);
        //关闭线程池
        executor.shutdown();

    }
}

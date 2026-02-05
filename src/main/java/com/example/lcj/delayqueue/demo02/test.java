package com.example.lcj.delayqueue.demo02;

import com.example.lcj.delayqueue.demo01.OrderDelayDto;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class test {
    public static void main(String[] args) {
        // 创建延时队列
        DelayQueue<OrderDelayDto> queue = new DelayQueue<>();

        //第一个订单，过期时间设置为一分钟后
        OrderDelayDto o1 = new OrderDelayDto();
        o1.setOrderCode("1001");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 1);
        o1.setExpirationTime(calendar.getTime());

        //第二个订单，过期时间设置为现在
        OrderDelayDto o2 = new OrderDelayDto();
        o2.setOrderCode("1002");
        o2.setExpirationTime(new Date());

        //运行线程
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new OrderCheckScheduler(queue));

        //往队列中放入数据
        queue.offer(o1);
        queue.offer(o2);

        exec.shutdown();
    }

}
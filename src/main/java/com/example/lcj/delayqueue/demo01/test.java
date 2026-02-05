package com.example.lcj.delayqueue.demo01;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.DelayQueue;

public class test {
    public static void main(String[] args) {
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

        //往队列中放入数据
        queue.offer(o1);
        queue.offer(o2);

        // 延时队列
        while (true) {
            try {
                OrderDelayDto take = queue.take();
                System.out.println("订单编号：" + take.getOrderCode() + " 过期时间：" + take.getExpirationTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
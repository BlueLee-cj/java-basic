package com.example.lcj.thread.juc.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lichengjian
 * @date 2021/10/5
 */
public class CycliBarrierDemo2 {
    static final int parties = 10;
    static final Random random = new Random();
    static final CyclicBarrier cyclicBarrier = new CyclicBarrier(parties);


    static class StaffThread extends Thread {
        @Override
        public void run() {
            try {
                String staff = "员工【" + Thread.currentThread().getName() + "】";

                // 第一阶段：来公司集合
                System.out.println(staff + "从家出发了……");
                Thread.sleep(random.nextInt(5000));
                System.out.println(staff + "到达公司");

                // 协同，第一次等大家到齐
                cyclicBarrier.await();

                // 第二阶段：出发去公园
                System.out.println(staff + "出发去公园玩");
                Thread.sleep(random.nextInt(5000));
                System.out.println(staff + "到达公园门口集合");

                // 协同：第二次等大家到齐
                cyclicBarrier.await();

                // 第三阶段：去餐厅
                System.out.println(staff + "出发去餐厅");
                Thread.sleep(random.nextInt(5000));
                System.out.println(staff + "到达餐厅");

                // 协同：第三次等大家到齐
                cyclicBarrier.await();

                // 第四阶段：就餐
                System.out.println(staff + "开始用餐");
                Thread.sleep(random.nextInt(5000));
                System.out.println(staff + "用餐结束，回家");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        // 所有人，开始行动
        for (int i = 0; i < parties; i++) {
            new StaffThread().start();
        }

    }
}

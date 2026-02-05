package com.example.lcj.random;

import java.util.Random;

/**
 * @author lichengjian
 * @date 2022/9/12
 */
public class RandomTest {
    public static void main(String[] args) {
        // 创建两个线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                // 创建 Random 对象，设置相同的种子
                Random random = new Random(1024);
                // 生成 3 次随机数
                for (int j = 0; j < 3; j++) {
                    // 生成随机数
                    int number = random.nextInt();
                    // 打印生成的随机数
                    System.out.println(Thread.currentThread().getName() + ":" +
                            number);
                    // 休眠 200 ms
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---------------------");
                }
            }).start();
        }
    }
}

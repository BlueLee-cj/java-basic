package com.example.lcj.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author lichengjian
 * @date 2022/9/12
 */
public class ThreadLocalRandomTest {
    public static void main(String[] args) {
        // 得到 ThreadLocalRandom 对象
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            // 生成 0-9 随机整数
            int number = random.nextInt(10);
            // 打印结果
            System.out.println("生成随机数：" + number);
        }
    }
}

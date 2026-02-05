package com.example.lcj.random;

/**
 * @author lichengjian
 * @date 2022/9/12
 */
public class MathTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            // 产生随机数
            double number = Math.random();
            System.out.println("生成随机数：" + number);
        }
    }
}

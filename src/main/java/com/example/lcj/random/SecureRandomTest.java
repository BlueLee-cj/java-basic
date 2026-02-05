package com.example.lcj.random;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author lichengjian
 * @date 2022/9/12
 */
public class SecureRandomTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // 创建 SecureRandom 对象，并设置加密算法
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        for (int i = 0; i < 10; i++) {
            // 生成 0-9 随机整数
            int number = random.nextInt(10);
            // 打印结果
            System.out.println("生成随机数：" + number);
        }
    }
}

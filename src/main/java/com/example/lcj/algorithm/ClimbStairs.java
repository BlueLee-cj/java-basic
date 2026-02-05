package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：假设你正在爬楼梯。需要 _n_ 步你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意： 给定 _n_ 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1\.  1 步 + 1 步
 * 2\.  2 步
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1\.  1 步 + 1 步 + 1 步
 * 2\.  1 步 + 2 步
 * 3\.  2 步 + 1 步
 * <p>
 * 裴波拉切数
 * <p>
 * 定义F(n)表示到达第n个台阶的方法，则F(n) = F(n - 1) +F(n - 2) ；
 * @modified By：
 * @date ：Created in 2019/8/3 9:54
 * 1 2 3 5 8 13 21

 * 1  1  1 1
 * 1  2  1
 * 1  1  2
 * 2  1  1
 * 2  2

 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(climbStairs(12));
        System.out.println(climbStairs2(12));
    }

    public static int climbStairs(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        //初始化
        int x = 1;
        int y = 2;
        int result = 0;
        while (n >= 3) {
            result = x + y;
            x = y;
            y = result;
            n--;
        }
        return result;
    }

    public static int climbStairs2(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        //初始化
        int x = 1;
        int y = 2;
        int result = 0;
        int step = 3;
        while (step <= n) {
            result = x + y;
            x = y;
            y = result;
            step++;
        }
        return result;
    }
}





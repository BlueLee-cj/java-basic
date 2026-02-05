package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：给定一个整数 _n_ ，返回 _n_ ! 结果尾数中零的数量。
 * 示例 1:
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * 示例 2:
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * 说明: 你算法的时间复杂度应为 _O_ (log _n_ ) 。
 * @modified By：
 * @date ：Created in 2019/8/19 21:55
 */
public class TrailingZeroes {
    public static void main(String[] args) {
        long n = 20;
        System.out.println(method(n));
    }
    //10 9 8 7 6 5 4 3 2 1
    public static long method(long n) {
        long temp = 1;
        for(long i = 1 ; i <= n; i++){
            temp *= i;
        }
        System.out.println("结果是" + temp);
        int result = 0;
        while (n > 4) {
            n /= 5;
            result += n;
        }
        return result;
    }
}

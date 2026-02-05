package com.example.lcj.algorithm;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @author ：lcj
 * @description： 给定一个整数数组 `nums` ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @modified By：
 * @date ：Created in 2019/8/2 20:07
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] arr1 = {1, 1, 2,-1, 3, 4, 5, -5, 4};
        System.out.println("max:" + methodA(arr1));
    }

    public static int methodA(int[] arr) {
        int y = arr[0];
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                x += arr[j];
                if (x > y) {
                    y = x;
                    a = i;
                    b = j;
                }
            }
        }
        for (int i = a; i <= b; i++) {
            System.out.println(arr[i]);
        }
        return y;
    }

}

package com.example.lcj.algorithm;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author ：lcj
 * @description：给定一个 非空 整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。
 * 找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 * @modified By：
 * @date ：Created in 2019/8/19 21:13
 */
public class OnlyOneExist {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 4, 3, 4, 2};
        System.out.println(method1(arr));
        System.out.println(singleNumber(arr));
    }

    private static int method1(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : arr) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }

    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
}

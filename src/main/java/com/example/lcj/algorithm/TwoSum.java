package com.example.lcj.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：lcj
 * @description：给定一个已按照 _升序排列_ 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2 _。_
 * 说明:
 * *   返回的下标值（index1 和 index2）不是从零开始的。
 * *   你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @modified By：
 * @date ：Created in 2019/8/19 21:28
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 5, 9, 11, 33, 66};
        int targert = 44;
        System.out.println(method(numbers, targert)[0] + "  " + method(numbers, targert)[1]);

    }

    public static int[] method(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            long sum = numbers[left] + numbers[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                int[] res = new int[2];
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }


    public int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

}

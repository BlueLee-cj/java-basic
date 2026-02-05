package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description： 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @modified By：
 * @date ：Created in 2019/8/2 16:01
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 4, 5, 5, 6, 6, 6};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int number = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[number]) {
                number++;
                nums[number] = nums[i];
            }
        }
        System.out.println(nums.toString());
        return number + 1;
    }
}

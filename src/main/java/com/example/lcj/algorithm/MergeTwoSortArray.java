package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：给定两个有序整数数组 _nums1_ 和 _nums2_ ，将 _nums2_ 合并到 _nums1_ 中 _，_ 使得 _num1_ 成为一个有序数组。
 * 说明:
 * *   初始化 _nums1_ 和 _nums2_ 的元素数量分别为 _m_ 和 _n_ 。
 * *   你可以假设 _nums1_ 有足够的空间（空间大小大于或等于 _m + n_ ）来保存 _nums2_ 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @modified By：
 * @date ：Created in 2019/8/3 10:45
 */
public class MergeTwoSortArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 5, 6};
        int m = nums1.length;
        int n = nums2.length;
        int[] merge = merge(nums1, m, nums2, n);
        System.out.println(merge);
        int[] merge2 = merge2(nums1, m, nums2, n);
        System.out.println(merge2);
    }

    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        int[] nums = new int[m + n];
        while (index >= 0) {
            if (i < 0) {
                //第一个数组已经遍历完毕
                nums[index--] = nums2[j--];
            } else if (j < 0) {
                //第二个数组已经遍历完毕
                nums[index--] = nums1[i--];
            } else if (nums1[i] > nums2[j] && i >= 0) {
                //比较两个数组元素
                nums[index--] = nums1[i--];
            } else if (nums1[i] <= nums2[j] && j >= 0) {
                nums[index--] = nums2[j--];
            }
        }
        return nums;
    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        //合并后最后一个数的索引为m+n-1
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        int[] nums = new int[m + n];
        while (i >= 0 && j >= 0) {
            //将两个数组中从最后一位开始比较，较大的先插入
            //当j先等于0时，说明nums2的数字已经全部复制到nums1中，此时合并完成(说明nums1中最小的元素比nums2小)
            //当i先等于0时，说明nums1中原来的所有数字已经复制完毕，此时进入下面的循环(说明nums1中最小的元素比nums2大)
            nums[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums[k--] = nums2[j--];
        }
        while (i >= 0) {
            nums[k--] = nums1[i--];
        }
        return nums;
    }

}

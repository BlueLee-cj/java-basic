package com.example.lcj.algorithm;

/**
 * @author ：lcj
 * @description：移除元素 给定一个数组 _nums_ 和一个值 _val_ ，你需要  移除所有数值等于 _val_ 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 示例 1:
 * 给定 _nums_ = [3,2,2,3], _val_ = 3,
 * 函数应该返回新的长度 2, 并且 _nums_ 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * 给定 _nums_ = [0,1,2,2,3,0,4,2], _val_ = 2,
 * 函数应该返回新的长度 `5`, 并且 _nums_ 中的前五个元素为 `0`, `1`, `3`, `0`, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以 “引用” 方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * @modified By：
 * @date ：Created in 2019/8/2 16:50
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] arrs = {1, 2, 3, 4, 3, 5};
        int a = 3;
        System.out.println("changdu:" + methodA(arrs, a));
    }

    public static int methodA(int[] arrs, int a) {
        int j = 0;
        for (int i = 0; i < arrs.length; i++) {
            if (arrs[i] != a) {
                arrs[j] = arrs[i];
                j++;
            }
        }
        for (int i = 0; i < arrs.length; i++) {
            if(i > j-1){
                arrs[i] = 0;
            }
            System.out.println(arrs[i]);
        }

        return j;
    }
}

package com.example.lcj.algorithm;

import java.util.ArrayList;

/**
 * 这个算法有一个前提是:数组是先经过排序的
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * @author 汤小萌
 */
public class DeleteDuplicatesElement {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3,};
        System.out.println(removeTheagain(nums));
//        System.out.println(removeTheagain(nums));
//        System.out.println(removeTheagain(nums));
    }

    // 方法一:使用ArrayList
    public static int removeTheagain(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return 1;
        } else {
            int i = 0;
            int n = array.length - 1; // 数组的最后一个元素的索引
            while (i <= n) {
                if (i == n) { // 走到了最后一个元素了,肯定是没有重复的 > 先先下面的算法
                    list.add(array[i]);
                } else {
                    int j = i + 1; // 需要用来跟前面的元素进行比较的索引
                    if (array[i] == array[j]) { // 跟i索引大1的的元素跟i相等(相邻的两个元素相等)
                        // 跟i相邻的后一个元素跟i相等,那么还需要继续判断这个元素之后的元素是否跟i有相等的
                        while (j <= n && array[i] == array[j]) { // 遍历完元素,或者一旦发现没有相等了的就跳出来,(数组之前就已经进行了排序)
                            j++; // 如果后面的跟当前i有相等的,那么j就不断往后走,看后面是否还有相等的
                        }
                    }
                    list.add(i); // 需要把i索引加入到这个list集合中
                    // i的索引需要变成i相同元素的最后一个索引加1的位置(因为这个位置是跟i是不同的之后的第一个位置)
                    i = j;  // 此时还可能在循环中,还需要继续进行判断
                }
            }
        }
        for (int k = 0; k < list.size(); k++) {
            array[k] = list.get(k);
        }
        return list.size();
    }

    // 方法二:
    // 数组下标（指针）与临时变量，是解决数组相关面试题的两大法宝
    public static int removeTheAgain02(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return 1;
        } else {
            // 定义一个临时的变量开始就是数组的第一个元素  (这个临时变量可以看成是一个指针)
            // 一旦发现了出现了不一样的数组,这个临时变量就需要变成下一个不重复的数组的元素了
            int temp = array[0];
            int len = 1;
            for (int i = 1; i < array.length; i++) {
                if (temp == array[i]) { // 如果数组的元素一直跟这个临时变量的值是相等的,那么就一直continue
                    continue;
                } else {
                    // 如果发现了数组中的元素跟这个临时变量的值不一样的话,那么这个临时
                    // 变量就要往下走,变成这个不重复的元素
                    temp = array[i];

                    array[len] = array[i]; // 如果只是想等到长度的话,这段代码是可以不用写的
                    len++; // 这个len就相当于是一个计数器(计算的是不重复元素的个数)
                }
            }
            return len;
        }
    }
    // 这个算法更加巧妙,跟上面的算法有类似的地方,但是这个算法更加简便

    /**
     * 数组完成排序后，我们可以放置两个指针 i 和 j，其中 i 是慢指针，而 j 是快指针。只要
     * nums[i]=nums[j]，我们就增加 j 以跳过重复项
     * 当我们遇到 nums[j]≠nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复
     * 制到 nums[i+1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     *
     * @param nums
     * @return
     */
    public static int removeTheAgain03(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) { //
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
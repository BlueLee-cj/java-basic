package com.example.lcj.algorithm;

import java.util.List;

/**
 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 *
 * [2]
 * [3,4]
 * [6,5,7]
 * [4,1,8,3]
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
class Triangle {
    public static void main(String[] args) {

    }
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。
            int[][] dp = new int[n + 1][n + 1];
            // 从三角形的最后一行开始递推。
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
            return dp[0][0];
        }
    }

}

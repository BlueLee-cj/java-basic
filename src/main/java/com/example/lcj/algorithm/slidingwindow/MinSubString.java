package com.example.lcj.algorithm.slidingwindow;

/**
 * 最小子串
 *
 * @author lichengjian
 * @date 2022/6/12
 */
public class MinSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        // need[i]表示需要该元素的数量,0代表不需要, <0代表多余的数量
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // i滑动窗口左端，j右端
        int i = 0, j = 0;
        // 当前发现的满足要求的最小窗口长度
        int minSize = Integer.MAX_VALUE;
        // 所需元素的总数量
        int needCnt = t.length();
        int start = 0;
        while (j < s.length()) {
            // 步骤一：不断增加j使滑动窗口增大，直到窗口包含了T的所有元素
            char jChar = s.charAt(j);
            if (need[jChar] > 0) {// 新加入的字符使我们需要的元素
                needCnt--;
            }
            need[jChar]--;

            // 此时窗窗口包含了T的所有元素，进入步骤二，增加i，扔掉不需要的元素
            if (needCnt == 0) {
                char iChar = s.charAt(i);
                while (need[iChar] < 0) {
                    // 向右移动一格
                    need[iChar]++;
                    i++;
                    iChar = s.charAt(i);
                }
                if (j - i + 1 < minSize) {
                    minSize = j - i + 1;
                    start = i;// 只有发现最小值时才更新start
                }
                // 步骤三：让i再向右移动一个位置，使窗口不再满足条件，让其再次寻找，进入步骤一

                need[s.charAt(i)]++;
                i++;
                needCnt++;
            }
            j++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);
    }
}


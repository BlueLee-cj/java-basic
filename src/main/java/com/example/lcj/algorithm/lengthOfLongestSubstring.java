package com.example.lcj.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ：lcj
 * @description：
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date ：Created in 2020/12/6 16:37
 */
public class lengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(method01(s));
        System.out.println(method02(s));
    }


    public static int method01(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static int method02(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public int method03(String s) {
        // 异常输入排查
        if(s==null||s.length()==0){
            return 0;
        }
        int ans=0;
        int len=s.length();
        int start = 0;
        int end = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        // 右指针不断向前，直到字符串尾部
        while(end<len){
            ans = Math.max(ans,end-start);
            // 当遇到重复值，说明左指针需要跳转，跳转的位置是该重复值的下标+1
            // 比如字符串abcdecf，到遇到第二个c，即便从bcde任意一个开始，长度都无法超过a，只有从decf开始计算才是新一轮查找
            // 值得注意的是，如果碰到了重复值的下标比左指针还小的情况，不应该跳转，因为左指针左边的元素不再窗口内，比如abba
            if(map.containsKey(s.charAt(end)) && map.get(s.charAt(end))>=start){
                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end),end);		// 无论重不重复都需要更新，该元素最近的下标
            end++;
        }
        ans = Math.max(ans,end-start);
        return ans;
    }
}
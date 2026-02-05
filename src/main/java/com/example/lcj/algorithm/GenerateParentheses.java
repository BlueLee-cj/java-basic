package com.example.lcj.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：lcj
 * @description：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date ：Created in 2020/11/1 17:50
 */
public class GenerateParentheses {

    private  List<String> result;
    public List<String> GenerateParenthesesMethod(int n){
        result = new ArrayList<String>();
        generate(0,0,n,"");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        if(left == n && right == n){
            result.add(s);
            return;
        }

        //if(left < n){
        //    generate(left + 1, right, n, s+"(");
        //}
        //if(right < n && right < left){
        //    generate(left , right+1, n, s+")");
        //}
        if(left < n){
            generate(left + 1, right, n, s+"(");
        }
        if(right < left){
            generate(left , right+1, n, s+")");
        }
    }


    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.GenerateParenthesesMethod(3));
    }
}

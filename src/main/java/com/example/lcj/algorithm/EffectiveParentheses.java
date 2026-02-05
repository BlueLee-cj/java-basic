package com.example.lcj.algorithm;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author ：lcj
 * @description：有效的括号
 * @modified By：
 * @date ：Created in 2019/8/2 8:39
 */
public class EffectiveParentheses<main> {
    public static void main(String[] args) {
//        Dueue<Object> objects = new ArrayDueue<>();
        System.out.println(isValid("{((aaaa))}"));
        System.out.println(isValid("){((aaaa))}"));
        System.out.println(isValid("(){}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (ch == ')' && topChar != '(') {
                    return false;
                } else if (ch == ']' && topChar != '[') {
                    return false;
                } else if (ch == '}' && topChar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

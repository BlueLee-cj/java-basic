package com.example.lcj.jdk8NewSyntax.java8888.fourinterface;

import java.util.function.Predicate;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class PredicateTest {
    public static void main(String[] args) {
        // 数字类型 判断值是否大于5
        Predicate<Integer> predicate = x -> x > 5;
        System.out.println(predicate.test(10));//true
        Predicate<Integer> predicate1 = x -> x < 7;

        // 字符串的非空判断
        Predicate<String> predicateStr = x -> null == x || "".equals(x);
        System.out.println(predicateStr.test(""));//true

        // and
        System.out.println(predicate.and(predicate1).test(7));

    }
}

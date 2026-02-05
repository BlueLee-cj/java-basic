package com.example.lcj.jdk8NewSyntax.java8888.fourinterface;

import java.util.function.UnaryOperator;

import org.junit.Test;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class UnaryOperatorTest {
    @Test
    public void test() {
        UnaryOperator<Integer> dda = x -> x + 1;
        System.out.println(dda.apply(10));// 11
        UnaryOperator<String> ddb = x -> x + 1;
        System.out.println(ddb.apply("aa"));// aa1
    }
}

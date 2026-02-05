package com.example.lcj.jdk8NewSyntax.fourinterface;

import org.junit.Test;

import java.util.function.UnaryOperator;

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

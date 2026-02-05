package com.example.lcj.jdk8NewSyntax.java8888.fourinterface;

import java.util.function.Consumer;

import org.junit.Test;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class ConsumerTest {
    @Test
    public void test1() {
        Consumer<Integer> consumer = x -> {
            int a = x + 2;
            System.out.println(a);// 12
            System.out.println(a + "_");// 12_
        };
        consumer.accept(10);
    }
}

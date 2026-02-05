package com.example.lcj.jdk8NewSyntax.java8.lambda;

/**
 * @author lichengjian
 * @date 2021/2/6
 */
@FunctionalInterface
public interface LambdaA {
    static void method1() {
        System.out.println("1");
    }

    void method2();

    // void method3();
}

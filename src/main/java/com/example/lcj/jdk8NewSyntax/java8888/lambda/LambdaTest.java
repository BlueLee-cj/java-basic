package com.example.lcj.jdk8NewSyntax.java8888.lambda;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;

import org.junit.Test;

/**
 * lamabd表达式中，需要有函数式接口的支持；
 * 函数式接口定义：接口中只有一个抽象方法的接口，称为函数式接口；
 *
 * 可以使用@FunctionalInterface注解修饰，对该接口做检查；如果接口里，有多个抽象方法，使用该注解，会有语法错误
 *
 * @author lichengjian
 * @date 2021/1/15
 */
public class LambdaTest {

    // 1）.无参数，无返回值的用法 ：() -> System.out.println("hello lambda");
    @Test
    public void test1() {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            }
        };
        r.run();
        Runnable r1 = () -> System.out.println("hello lambda");
        r1.run();
    }

    // 2).有一个参数，无返回值的用法： (x) -> System.out.println(x);
    // 或者 x -> System.out.println(x); 一个参数，
    @Test
    public void test2() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("有一个参数，无返回值的用法（Consumer函数式接口）");
    }

    // 3）.有两个参数，有返回值的：(x, y) -> x + y
    @Test
    public void test3() {
        BinaryOperator<Integer> binary = (x, y) -> x + y;
        System.out.println(binary.apply(1, 2));
    }

    @Test
    public void test4() {
        // 无返回值lambda函数体中用法
        Runnable r1 = () -> {
            System.out.println("hello lambda1");
            System.out.println("hello lambda2");
            System.out.println("hello lambda3");
        };
        r1.run();

        // 有返回值lambda函数体中用法
        BinaryOperator<Integer> binary = (x, y) -> {
            int a = x * 2;
            int b = y + 2;
            return a + b;
        };
        System.out.println(binary.apply(1, 2));// 3
        // 多行的，只需要用大括号{}把语句包含起来就可以了；
        // 有返回值和无返回值的，只有一个return的区别；只有一条语句的，大括号和renturn都可以不用写；
    }

    @Test
    public void test5() {
        BinaryOperator<Integer> binary = (Integer x, Integer y) -> x + y;
        System.out.println(binary.apply(1, 2));// 3
    }
}

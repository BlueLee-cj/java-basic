package com.example.lcj.jdk8NewSyntax.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    private static String end = ".";

    public static void main(String[] args) {
        // 直接使用JDK1.8提供的接口，不需要再定义IHello接口, 直接使用JDK提供的接口来接收Lambda表达式
        Supplier<String> supplier = () -> "mengday: happy new year everyone!";
        String result = supplier.get();
        System.out.println(result);

        Consumer<String> consumer = (name) -> System.out.println(name + ": " + "happy new year everyone!");
        consumer.accept("mengday");

        Function<String, String> func = (name) -> name + ": " + "happy new year everyone!";
        String hi = func.apply("mengday");
        System.out.println(hi);


        // 在代码块的内部可以访问静态全局变量
        // 在代码块中可以访问外边局部变量
        // 在代码块的内部可以修改全局静态变量
        // 在代码块内部是不能访问接口中的其它方法的
        String split = ": ";
        BiFunction<String, String, String> biFunction = (String name, String msg) -> {
            end = "!";
            String hello = name + split + msg + end;
            return hello;
        };
        String hello = biFunction.apply("mengday", "happy new year everyone");
        System.out.println(hello);

        // 根据字符串长度比较大小
        Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();
        int compare = comparator.compare("abc", "ab");
        System.out.println(compare);
    }
}
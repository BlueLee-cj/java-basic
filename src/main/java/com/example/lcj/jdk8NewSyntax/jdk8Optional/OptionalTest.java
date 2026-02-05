package com.example.lcj.jdk8NewSyntax.jdk8Optional;

import java.util.Optional;

/**
 * @author ：lcj
 * @description：Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。 Optional提供很多有用的方法，这样我们就不用显式进行空值检测
 * java8所提供的Optional类则在减少NullPointException的同时，也提升了代码的美观度。但首先我们需要明确的是，
 * 它并 不是对null关键字的一种替代，而是对于null判定提供了一种更加优雅的实现，从而避免NullPointException。
 * @date ：Created in 2019/10/30 10:42
 */
public class OptionalTest {
    public static void main(String[] args) {
        //1.对象创建
        //创建空对象
        Optional<String> optStr = Optional.empty();

        //创建对象：不允许为空  Optional提供了方法of()用于创建非空对象，该方法要求传入的参数不能为空，否则抛NullPointException
        String str = null;
        Optional<String> opt = Optional.of(str);  // 当str为null的时候，将抛出NullPointException

        //如果不能确定传入的参数是否存在null值的可能性，则可以用Optional的ofNullable()方法创建对象，如果入参为null，则创建一个空对象
        Optional<String> optStr1 = Optional.ofNullable(str);  // 如果str是null，则创建一个空对象

        method1();
        // 参数不能是null
        Optional<Integer> optional1 = Optional.of(1);

        // 参数可以是null
        Optional<Integer> optional2 = Optional.ofNullable(null);

        // 参数可以是非null
        Optional<Integer> optional3 = Optional.ofNullable(2);

        //Optional.empty()：所有null包装成的Optional对象：
        Optional<Integer> optional4 = Optional.ofNullable(null);
        Optional<Integer> optional5 = Optional.ofNullable(null);
        System.out.println(optional4 == optional5);// true
        System.out.println(optional4 == Optional.<Integer>empty());// true

        Object o1 = Optional.<Integer>empty();
        Object o2 = Optional.<String>empty();
        System.out.println(o1 == o2);// true


        Optional<Integer> optional6 = Optional.ofNullable(1);
        Optional<Integer> optional7 = Optional.ofNullable(null);
        // isPresent判断值是否存在
        System.out.println(optional6.isPresent() == true);
        System.out.println(optional7.isPresent() == false);
    }

    private static int method1() {
        String str = "123";
        if (null == str) { // 空指针判定
            return 0;
        }
        return str.length();
    }

    private static int method1_new() {
        String str = "123";
        return Optional.ofNullable(str).map(String::length).orElse(0);
    }
}

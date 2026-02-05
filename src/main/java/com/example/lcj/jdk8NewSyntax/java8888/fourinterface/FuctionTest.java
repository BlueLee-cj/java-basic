package com.example.lcj.jdk8NewSyntax.java8888.fourinterface;

import java.util.function.Function;

import org.junit.Test;

/**
 * @author lichengjian
 * @date 2021/1/15
 */
public class FuctionTest {
    @Test
    public void test1() {
        Function<Integer, Integer> function1 = x -> x * 2;
        System.out.println(function1.apply(4));// 8

        Function<Integer, String> function2 = x -> x * 2 + "dd";
        System.out.println(function2.apply(4));//8dd

        Function<String, String> strFunction1 = (str) -> new String(str);
        System.out.println(strFunction1.apply("aa"));//aa

        Function<String, String> strFunction2 = String::new;
        System.out.println(strFunction2.apply("bb"));//bb

        Function<String, Emp> objFunction1 = (str) -> new Emp(str);
        System.out.println(objFunction1.apply("cc").getName());//cc

        Function<String, Emp> objFunction2 = Emp::new;
        System.out.println(objFunction2.apply("dd").getName());//dd
    }

    public static class Emp {
        private String name;

        public Emp() {

        }

        public Emp(String name) {
            super();
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}

package com.example.lcj.jdk8NewSyntax.doublecolon;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class AcceptMethod {

    public static void printValur(String str) {
        System.out.println("print value : " + str);
    }

    public static void main(String[] args) {

        List<String> al = Arrays.asList("a", "b", "c", "d");
        for (String a : al) {
            AcceptMethod.printValur(a);
        }


        System.out.println("--------------al.forEach(x->-----------------------");
        //下面的for each循环和上面的循环是等价的
        al.forEach(x -> {
            AcceptMethod.printValur(x);
        });


        System.out.println("-----------------al.forEach(AcceptMethod--------------------");
        al.forEach(AcceptMethod::printValur);


        System.out.println("----------------Consumer<String>---------------------");
        //下面的方法和上面等价的
        Consumer<String> methodParam = AcceptMethod::printValur; //方法参数
        al.forEach(x -> methodParam.accept(x));//方法执行accept
    }
}
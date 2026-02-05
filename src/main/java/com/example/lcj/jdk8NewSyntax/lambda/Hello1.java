package com.example.lcj.jdk8NewSyntax.lambda;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/24 20:00
 */
public class Hello1 {
    int a = 10;
    String[] names = {"111", "333"};
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int a = 7;
            System.out.println(a);
            for (String name : names) {
                System.out.println(name);
            }
        }
    };
    Runnable runnable2 = () -> {
        // int a = 8;
        System.out.println(a);
        for (String name : names) {
            System.out.println(name);
        }
    };

    public static void main(String[] args) {
        Hello1 hello1 = new Hello1();
        hello1.runnable.run();
        hello1.runnable2.run();
    }
}

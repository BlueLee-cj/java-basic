package com.example.lcj.jdk8NewSyntax.lambda;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/24 19:51
 */
public class Hello {
    Runnable r1 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(toString());
        }
    };

    public String toString() {
        return "hello world";
    }

    public static void main(String[] args) {
        Hello hello2 = new Hello();
        hello2.r1.run();
        hello2.r2.run();
    }
}

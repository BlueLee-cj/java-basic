package com.example.lcj.jvm;

/**
 * @author ：lcj
 * @description：jvm入门
 * @date ：Created in 2020/8/26 13:44
 */
public class HelloWorld {
    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        int result = helloWorld.add();
        System.out.println(result);
    }

    public int add(){
        int a = 1;
        int b = 2;
        int c = (a + b) * 100;
        return c;
    }
}

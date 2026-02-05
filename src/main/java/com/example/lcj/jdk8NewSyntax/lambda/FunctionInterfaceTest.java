package com.example.lcj.jdk8NewSyntax.lambda;


/**
 * 函数接口测试
 * Created by Kevin on 2018/2/17.
 */
public class FunctionInterfaceTest {

    public static void main(String[] args) {
        testLambda();
    }

    private static void testLambda() {
        func(new FunctionInterface() {
            @Override
            public void test() {
                System.out.println("Hello World!");
            }
        });
        //使用Lambda表达式代替上面的匿名内部类
        func(() -> System.out.println("Hello World"));
    }

    private static void func(FunctionInterface functionInterface) {
        functionInterface.test();
    }
}


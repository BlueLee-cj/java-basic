package com.example.lcj.jdk8NewSyntax.lambda;

/**
 * 函数接口测试
 * Created by Kevin on 2018/2/17.
 */
public class FunctionInterfaceTest1 {

    public void testLambda() {
        //使用Lambda表达式代替匿名内部类
        func((x) -> System.out.println("Hello World" + x));
    }

    private void func(FunctionInterface1 functionInterface1) {
        int x = 1;
        functionInterface1.test(x);
    }
}


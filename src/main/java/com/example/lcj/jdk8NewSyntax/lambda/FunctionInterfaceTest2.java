package com.example.lcj.jdk8NewSyntax.lambda;


/**
 * 函数接口测试
 * Created by Kevin on 2018/2/17.
 */
public class FunctionInterfaceTest2 {
    public static void main(String[] args) {
        new FunctionInterfaceTest2().testLambda();
    }

    public void testLambda() {
        //使用Lambda表达式代替匿名内部类
        func((Integer x) -> true);
        //　此时的Lambda表达式“(Integer x) -> true”，右边是表达式的主体，直接返回true，如果有多行代码，则可以直接使用花括号表示
        func((Integer x) -> {
            System.out.println("Hello World" + x);
            return true;
        });
    }

    private void func(FunctionInterface2<Integer> functionInterface2) {
        int x = 1;
        functionInterface2.test(x);
    }
}
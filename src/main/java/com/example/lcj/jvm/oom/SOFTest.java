package com.example.lcj.jvm.oom;

public class SOFTest {
    public static void main(String[] args) {
        method();
    }

    // 递归调用导致 StackOverflowError
    public static void method() {
        method();
    }
}

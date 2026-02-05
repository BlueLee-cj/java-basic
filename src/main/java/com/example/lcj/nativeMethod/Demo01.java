package com.example.lcj.nativeMethod;

public class Demo01 {
    public native void hello();

    static {
        System.loadLibrary("hello");
    }

    public static void main(String[] args) {

        new Demo01().hello();
    }

}
package com.example.lcj.jvm.upgrade;

/**
 * @author lichengjian
 * @date 2021/7/17
 */
public class Demo1 {
    public static void main(String[] args) {
        byte[] array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = new byte[1024 * 1024];
        array1 = null;

        array1 = new byte[2 * 1024 * 1024];
    }
}

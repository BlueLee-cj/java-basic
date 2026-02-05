package com.example.lcj.jvm.upgrade;

/**
 * @author lichengjian
 * @date 2021/7/17
 */
public class Demo2 {
    public static void main(String[] args) {
        byte[] array1 = new byte[2*1024 * 1024];
        array1 = new byte[2*1024 * 1024];
        array1 = new byte[2*1024 * 1024];
        array1 = null;

        byte[] array2 = new byte[128 * 1024];

        byte[] array3 = new byte[2 * 1024 * 1024];

        array3 = new byte[2 * 1024 * 1024];

        array3 = new byte[2 * 1024 * 1024];

        array3 = new byte[128 * 1024];

        array3 = null;

        byte[] array4 = new byte[2 * 1024 * 1024];
    }
}

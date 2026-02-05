package com.example.lcj.thread.T44_PeferType;

import java.lang.ref.SoftReference;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/25 12:57
 */
public class T02_SoftPeference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        // m = null;
        System.out.println(m.get());
        System.gc();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(m.get());
        byte[] b = new byte[1024 * 1024 * 15];
        System.out.println(m.get());
    }
}

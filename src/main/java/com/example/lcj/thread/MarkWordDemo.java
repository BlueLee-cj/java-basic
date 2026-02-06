package com.example.lcj.thread;

import org.openjdk.jol.info.ClassLayout;

public class MarkWordDemo {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        // 1. 无锁状态
        System.out.println("=== 无锁状态 ===");
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        // 2. 调用 hashCode 后
        System.out.println("=== 调用 hashCode 后 ===");
        System.out.println("hashCode: " + Integer.toHexString(obj.hashCode()));
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        // 3. 加锁后（轻量级锁或重量级锁）
        System.out.println("=== synchronized 加锁后 ===");
        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}

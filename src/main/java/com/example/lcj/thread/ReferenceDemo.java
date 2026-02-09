package com.example.lcj.thread;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceDemo {

    public static void main(String[] args) {

        // 1. 强引用
        Object strongRef = new Object();
        System.gc();
        System.out.println("强引用: " + strongRef);  // 不为 null

        // 2. 软引用
        SoftReference<byte[]> softRef = new SoftReference<>(new byte[1024]);
        System.gc();
        System.out.println("软引用: " + softRef.get());  // 内存够，不为 null

        // 3. 弱引用
        WeakReference<Object> weakRef = new WeakReference<>(new Object());
        System.gc();
        System.out.println("弱引用: " + weakRef.get());  // null！GC 就回收

        // 4. 虚引用
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomRef = new PhantomReference<>(new Object(), queue);
        System.out.println("虚引用 get(): " + phantomRef.get());  // 永远是 null

        System.gc();
        // 检查引用队列，看对象是否被回收
        Reference<?> ref = queue.poll();
        System.out.println("引用队列: " + (ref != null ? "收到回收通知" : "无通知"));
    }
}

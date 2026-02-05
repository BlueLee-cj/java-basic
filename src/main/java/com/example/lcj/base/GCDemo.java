package com.example.lcj.base;

public class GCDemo {
    public static void main(String[] args) {
        Demo demo = new Demo();//该对象不会被回收
        // 没有变量引用,则说明该对象是垃圾,默认情况垃圾回收器不会立即回收,这取决于内存是否充足
        new Demo();//需要多测试几次
        // 可以手动调用垃圾回收器线程,回收垃圾对象
        System.gc();//输出Finalizer 垃圾回收线程号
        throw new RuntimeException();//在抛错的情况下不影响垃圾回收线程的执行 说明垃圾回收线程 和 主线程main 是并列的 互不影响的
    }
}
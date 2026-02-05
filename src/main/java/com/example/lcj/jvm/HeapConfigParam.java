package com.example.lcj.jvm;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/10 13:15
 */
public class HeapConfigParam {
    public static void main(String[] args) {
        //最大堆也就是Xmx参数指定的大小，表示java程序最大能使用多少内存大小，如果超过这个大小，那么java程序会报：out of memory（OOM错误）
        System.out.println("最大堆：" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        //空闲堆表示程序已经分配的内存大小减去已经使用的内存大小，
        // 而总的堆表示目前程序已经配置到多少内存大小，一般而言程序一启动，会按照-Xms5m先分配5M的空间，这时总的堆大小就是5M。
        System.out.println("空闲堆：" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("总的堆：" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
    }
}

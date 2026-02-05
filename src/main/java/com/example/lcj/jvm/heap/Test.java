package com.example.lcj.jvm.heap;

/**
 * @author ：lcj
 * @description：
 * -Xms60m 堆的最小空间大小。
 * -Xmx60m 堆的最大空间大小
 * -Xmn20m 新生代大小
 * -XX:NewRatio=2 新生代与老年代的比例 如 –XX:NewRatio=2，则新生代占整个堆空间的1/3，老年代占2/3
 * -XX:SurvivorRatio=8 新生代中 Eden 与 Survivor 的比值。默认值为 8。即 Eden 占新生代空间的 8/10，另外两个 Survivor 各占 1/10
 * -XX:PermSize=30m  永久代最小空间大小。
 * -XX:MaxPermSize=30m  永久代最大空间大小
 * -XX:+PrintGCDetails  打印 GC信息
 * ( 若 Xms = Xmx, 并且设定了 Xmn, 那么该项配置就不需要配置了 )
 * @date ：Created in 2020/4/19 19:53
 */
public class Test {
    public static void main(String[] args) {
         new Test().doTest();
    }
    public void doTest(){
         Integer M = new Integer(1024 * 1024 * 1);  //单位, 兆(M)
         byte[] bytes = new byte[1 * M]; //申请1M 大小的内存空间   17
         bytes = null;  //断开引用链
         System.gc();   //通知 GC 收集垃圾
         System.out.println();
         bytes = new byte[1 * M];  //重新申请1M 大小的内存空间   21
         bytes = new byte[1 * M];  //再次申请1M 大小的内存空间  22
         System.gc();
         System.out.println();
     }
}

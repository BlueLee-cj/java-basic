package com.example.lcj.jvm.oom;

import java.util.ArrayList;
import java.util.List;

public class heapOOMTest {
    public static void main(String[] args) throws InterruptedException {
        List list = new ArrayList(); // 持有“大对象”的引用，防止垃圾回收
        Thread.sleep(30000);
        while (true) {
            int[] tmp = new int[10000000]; // 不断创建“大对象”
            list.add(tmp);
        }
    }
}


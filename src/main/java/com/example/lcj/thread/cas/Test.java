package com.example.lcj.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/24 8:59
 */
public class Test {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(2);
        System.out.println(i);
        i.decrementAndGet();
        System.out.println(i);

    }
}

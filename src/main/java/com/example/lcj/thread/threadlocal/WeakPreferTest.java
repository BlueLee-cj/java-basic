package com.example.lcj.thread.threadlocal;

import com.example.lcj.thread.T44_PeferType.M;

import java.lang.ref.WeakReference;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/25 12:53
 */
public class WeakPreferTest {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());
        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.get();
        tl.remove();
    }
}

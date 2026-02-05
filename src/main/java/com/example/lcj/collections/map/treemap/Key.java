package com.example.lcj.collections.map.treemap;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/10 14:34
 */
public class Key implements Comparable<Key> {

    //返回负的常数，表示此对象永远小于于输入入的other对象．此处决定treemap的size=2
    @Override
    public int compareTo(Key o) {
        return -1;
    }

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

package com.example.lcj.base.staticmethod;

public class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    // 对静态方法使用<T>:
    public  Pair<T> create1(T first, T last) {
        return new Pair<>(first, last);
    }

    // 可以编译通过:但实际上，这个<T>和Pair<T>类型的<T>已经没有任何关系了。
    public static <T> Pair<T> create2(T first, T last) {
        return new Pair<>(first, last);
    }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<>(first, last);
    }
}

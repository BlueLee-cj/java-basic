package com.example.lcj.base.instanceT;

public class Pair<T> {
    private T first;
    private T last;

    public Pair(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        first = clazz.newInstance();
        last = clazz.newInstance();
    }

    public boolean same(T t) {
        return this == t;
    }
}

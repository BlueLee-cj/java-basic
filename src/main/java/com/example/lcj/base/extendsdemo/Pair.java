package com.example.lcj.base.extendsdemo;

class Pair<T> {
    private T first;
    private T last;

    Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setLast(T last) {
        this.last = last;
    }

    public T getLast() {
        return last;
    }
}

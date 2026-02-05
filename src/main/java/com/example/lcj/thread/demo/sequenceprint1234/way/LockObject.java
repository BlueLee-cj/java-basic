package com.example.lcj.thread.demo.sequenceprint1234.way;

public class LockObject {
    int value = 0;
    final static int maxvalue = 100;

    public int getValue() {

        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

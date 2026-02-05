package com.example.lcj.thread.contextswitch;

abstract class Threadcontextswitchtester {
    public static final int count = 100000000;
    public volatile int counter = 0;

    public int getcount() {
        return this.counter;
    }

    public void increasecounter() {
        this.counter += 1;
    }

    public abstract void start();
}

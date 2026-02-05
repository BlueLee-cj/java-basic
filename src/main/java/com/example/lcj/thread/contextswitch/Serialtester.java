package com.example.lcj.thread.contextswitch;

class Serialtester extends Threadcontextswitchtester {
    @Override
    public void start() {
        long start = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            System.out.println("serial exec time: " + (-start) + "s");
        }
    }
}

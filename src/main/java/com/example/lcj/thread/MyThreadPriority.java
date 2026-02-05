package com.example.lcj.thread;

class MyThreadPriority extends Thread {
    @Override
    public void run() {
        System.out.println("MyThreadPriority run priority=" + this.getPriority());
    }
}
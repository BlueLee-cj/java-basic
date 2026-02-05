package com.example.lcj.thread.T00Executors;

import java.util.concurrent.*;

public class ThreadTestA {
    public static void main(String[] args) {
        ExecutorService e = Executors.newFixedThreadPool(10);
        e.execute(new MyRunnableA());
        e.execute(new MyRunnableB());
        e.shutdown();
    }

} 
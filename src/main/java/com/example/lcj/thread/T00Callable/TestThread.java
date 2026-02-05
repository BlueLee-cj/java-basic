package com.example.lcj.thread.T00Callable;

import java.util.concurrent.FutureTask;

public class TestThread {
    public static void main(String[] args) {

        FutureTask<String> ft = new FutureTask<>(new ThreadCall());
        new Thread(ft).start();
    }

}

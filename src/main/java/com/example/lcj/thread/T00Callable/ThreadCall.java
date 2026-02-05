package com.example.lcj.thread.T00Callable;

import java.util.concurrent.Callable;

public class ThreadCall implements Callable<String> {

    @Override
    public String call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("=====");
        return "9999";
    }


}

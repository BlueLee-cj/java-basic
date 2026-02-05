package com.example.lcj.thread.T00Callable;

import java.util.concurrent.Callable;

class MyCallable implements Callable {
    private String oid;

    MyCallable(String oid) {
        this.oid = oid;
    }

    @Override
    public Object call() throws Exception {
        return oid + "任务返回的内容";
    }
}

package com.example.lcj.base;

class MyThead extends Thread {

    @Override
    public void run() {
        System.out.println("当前线程的名称为:" + Thread.currentThread().getName());
    }
}

package com.example.lcj.base;

class Demo {
    @Override
    protected void finalize() throws Throwable {
        // 此方法被调用说明,调用当前方法的对象会被回收
        System.out.println("finalizer方法被调用,调用当前方法的线程为:"
                + Thread.currentThread().getName());
    }
}
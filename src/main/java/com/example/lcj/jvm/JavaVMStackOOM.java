package com.example.lcj.jvm;

/**
 * java栈溢出OutOfMemoryError
 * JVM参数：-Xss2m
 * Created by chenjunyi on 2018/4/25.
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {
        }
    }

    //通过不断的创建新的线程使Stack内存耗尽
    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> dontStop());
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
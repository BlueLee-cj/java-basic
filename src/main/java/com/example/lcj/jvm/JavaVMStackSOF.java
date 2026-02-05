package com.example.lcj.jvm;

import org.apache.commons.lang.math.RandomUtils;

/**
 * java栈溢出StackOverFlowError
 * JVM参数：-Xss128k
 * Created by chenjunyi on 2018/4/25.
 */
public class JavaVMStackSOF {

    private int stackLength = -1;

    //通过递归调用造成StackOverFlowError
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("Stack length:" + oom.stackLength);
            e.printStackTrace();
        }
    }

}

package com.example.lcj.thread.T217ExceptionThrowLock;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/4 9:53
 */
public class Service {
    synchronized public void testMoethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("ThreadName =" + Thread.currentThread().getName() + " run beginTime =  " + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                System.out.println("ThreadName =" + Thread.currentThread().getName() + " run exceptionTime =  " + System.currentTimeMillis());
                int x = 0;
                int y = 0 / x;
            }
        } else {
            System.out.println("ThreadName =" + Thread.currentThread().getName() + " run beginTime =  " + System.currentTimeMillis());
        }
    }
}

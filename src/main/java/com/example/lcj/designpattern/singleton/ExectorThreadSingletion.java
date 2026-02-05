package com.example.lcj.designpattern.singleton;

/**
 * @author lichengjian
 * @date 2021/3/12
 */
public class ExectorThreadSingletion implements Runnable {

    @Override
    public void run() {
        ThreadLocalSingletion instance = ThreadLocalSingletion.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}

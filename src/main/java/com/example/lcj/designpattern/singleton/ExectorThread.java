package com.example.lcj.designpattern.singleton;

/**
 * @author lichengjian
 * @date 2021/3/12
 */
public class ExectorThread implements Runnable{

    @Override
    public void run() {
        LazySimpleSingleton instance = LazySimpleSingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + ":" + instance);
    }
}

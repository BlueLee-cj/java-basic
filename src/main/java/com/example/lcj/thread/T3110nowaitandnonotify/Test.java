package com.example.lcj.thread.T3110nowaitandnonotify;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/12/9 21:44
 */
public class Test {
    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        threadA.setName("a");
        threadA.start();
        ThreadB threadB = new ThreadB(myList);
        threadB.setName("b");
        threadB.start();
    }
}

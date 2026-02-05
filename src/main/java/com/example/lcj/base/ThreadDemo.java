package com.example.lcj.base;

public class ThreadDemo {

    public static void main(String[] args) {
        System.out.println("运行main方法的线程名称为:" + Thread.currentThread().getName());
        MyThead my1 = new MyThead();
        MyThead my2 = new MyThead();
//      my1.run();//main 线程就是main  run方法不是真正的调用线程
//      my2.run();//main 线程就是main
        // 线程已经就绪完毕,随时可以执行,但是是否被cpu选中还需要看线程的队列(考虑策略和权重)
        my1.start();//Thread-0
        my2.start();//Thread-1
    }
}

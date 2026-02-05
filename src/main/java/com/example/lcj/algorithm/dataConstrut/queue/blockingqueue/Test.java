package com.example.lcj.algorithm.dataConstrut.queue.blockingqueue;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/28 22:46
 */
public class Test {
    public static void main(String[] args) {
        MyBlockQueue myBlockQueue = new MyBlockQueue(3);
        for (int i = 0; i < 3; i++) {
            new Thread(new Producer(myBlockQueue), "生产者" + i).start();
            new Thread(new Consumer(myBlockQueue), "消费者" + i).start();
        }
    }
}

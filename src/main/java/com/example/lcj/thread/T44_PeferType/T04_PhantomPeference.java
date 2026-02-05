package com.example.lcj.thread.T44_PeferType;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/25 12:57
 */
public class T04_PhantomPeference {
    private static  final List<Object> LIST = new LinkedList<>();
    private static  final ReferenceQueue<M> QUEUE = new ReferenceQueue<>();

    public static void main(String[] args) {
        PhantomReference<M> mPhantomReference = new PhantomReference<>(new M(), QUEUE);
        new Thread(()->{
            while(true){
                LIST.add(new byte[1024*1024]);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
                System.out.println(mPhantomReference.get());
            }
        }).start();

        new Thread(()->{
            while(true){
                Reference<? extends M> poll = QUEUE.poll();
                if(poll != null){
                    System.out.println("----虚引用对象被JVM回收了--------" + poll);
                }

            }
        }).start();
    }
}

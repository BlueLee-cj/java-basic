package com.example.lcj.thread;

/**
 * Synchronized 原理演示
 * 
 * 查看字节码：javap -v SynchronizedDemo.class
 */
public class SynchronizedDemo {
    
    private int count = 0;
    private static int staticCount = 0;
    
    /**
     * 1. 同步代码块 - 锁的是括号里的对象
     */
    public void syncBlock() {
        synchronized (this) {
            count++;
        }
    }
    
    /**
     * 2. 同步实例方法 - 锁的是 this 对象
     * 字节码中没有 monitorenter/monitorexit，而是方法标志 ACC_SYNCHRONIZED
     */
    public synchronized void syncMethod() {
        count++;
    }
    
    /**
     * 3. 同步静态方法 - 锁的是 Class 对象
     */
    public static synchronized void syncStaticMethod() {
        staticCount++;
    }
    
    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        
        // 同步代码块
        demo.syncBlock();
        
        // 同步实例方法
        demo.syncMethod();
        
        // 同步静态方法
        SynchronizedDemo.syncStaticMethod();
        
        System.out.println("count: " + demo.count);
        System.out.println("staticCount: " + staticCount);
    }
}

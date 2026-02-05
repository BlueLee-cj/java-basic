package com.example.lcj.thread.T07interrupt;

/**
 * 1、interrupt()
 * interrupt方法用于中断线程。调用该方法的线程的状态为将被置为"中断"状态。
 * 注意：线程中断仅仅是置线程的中断状态位，不会停止线程。需要用户自己去监视线程的状态为并做处理。
 * 支持线程中断的方法（也就是线程中断后会抛出interruptedException的方法）就是在监视线程的中断状态，一旦线程的中断状态被置为“中断状态”，就会抛出中断异常。
 */
public class Interrupt {
    public static void main(String[] args) throws Exception {  
        Thread t = new Thread(new Worker());  
        t.start();  
          
        Thread.sleep(200);  
        t.interrupt();  
          
        System.out.println("Main thread stopped.");  
    }  
      
    public static class Worker implements Runnable {  
        public void run() {  
            System.out.println("Worker started.");  
              
            try {  
                Thread.sleep(500);  
            } catch (InterruptedException e) {  
                System.out.println("Worker IsInterrupted: " +   
                        Thread.currentThread().isInterrupted());  
            }  
              
            System.out.println("Worker stopped.");  
        }  
    }

    /**
     * 结论：interrupt方法是用于中断线程的，调用该方法的线程的状态将被置为"中断"状态。
     * 注意：线程中断仅仅是设置线程的中断状态位，不会停止线程。所以当一个线程处于中断状态时，
     * 如果再由wait、sleep以及join三个方法引起的阻塞，那么JVM会将线程的中断标志重新设置为false，
     * 并抛出一个InterruptedException异常，然后开发人员可以中断状态位“的本质作用-----
     * 就是程序员根据try-catch功能块捕捉jvm抛出的InterruptedException异常来做各种处理，
     * 比如如何退出线程。总之interrupt的作用就是需要用户自己去监视线程的状态位并做处理。”
     */
}  
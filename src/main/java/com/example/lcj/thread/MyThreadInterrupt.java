package com.example.lcj.thread;

import java.io.IOException;

public class MyThreadInterrupt {

    public static void main(String[] args) throws IOException {
        MyThreadInterrupt test = new MyThreadInterrupt();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {

        }
        System.out.println("���߳�ִ�����");
        thread.interrupt();
    }

    class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                System.out.println("����˯��״̬");
                Thread.currentThread().sleep(10000);
                System.out.println("˯�����");
            } catch (InterruptedException e) {
                System.out.println("�õ��ж��쳣");
            }
            System.out.println("run����ִ�����");
        }
    }

    class MyThread2 extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < Integer.MAX_VALUE) {
                System.out.println(i + " whileѭ��");
                i++;
            }
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (!isInterrupted() && i < Integer.MAX_VALUE) {
                System.out.println(i + " whileѭ��");
                i++;
                //If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object class, or of the join(), join(long), join(long, int), T05sleep(long), or T05sleep(long, int), methods of this class, then its interrupt status will be cleared and it will receive an InterruptedException.
//                try {
//					Thread.T05sleep(1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
            }
        }
    }
}

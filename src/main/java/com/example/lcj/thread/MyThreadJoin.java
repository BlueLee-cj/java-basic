package com.example.lcj.thread;

import java.io.IOException;

/**
 * �� main�߳� ���е� thread1.join() ʱ��main�̻߳����̶߳���thread1����(wait ��ζ���õ��ö������)��
 * ֻҪ thread1�߳� �� �ͻ���øö�������wait()�������� main�̣߳�
 * ֱ�� thread1�߳� �˳��Ż�ʹ main�߳� ���Լ���ִ�С�
 *
 * @author lcj
 */
public class MyThreadJoin {

    public static void main(String[] args) throws IOException {
        System.out.println("�����߳�" + Thread.currentThread().getName());
        MyThreadJoin test = new MyThreadJoin();
        MyThread thread1 = test.new MyThread();
        thread1.start();
        try {
            System.out.println("�߳�" + Thread.currentThread().getName() + "�ȴ�");
            thread1.join();
            System.out.println("�߳�" + Thread.currentThread().getName() + "����ִ��");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("�����߳�" + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            System.out.println("�߳�" + Thread.currentThread().getName() + "ִ�����");
        }
    }
}

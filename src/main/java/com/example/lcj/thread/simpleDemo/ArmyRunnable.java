package com.example.lcj.thread.simpleDemo;

public class ArmyRunnable implements Runnable {
    //volatile ��֤���߳̿�����ȷ�Ķ�ȡ�����߳�д��ֵ
    volatile boolean keepRunning = true;

    @Override
    public void run() {
        while (keepRunning) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "�����Է���" + i + "��");
            }
            //�ó�������ʱ�䣬�´�˭��������һ��
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "������ս��");
    }

}

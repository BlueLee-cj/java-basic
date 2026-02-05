package com.example.lcj.thread.demo;

public class Station extends Thread {
    // ͨ�����췽�����߳����ָ�ֵ
    public Station(String name) {
        super(name);// ���߳����ָ�ֵ
    }

    // Ϊ�˱���Ʊ����һ�£�Ʊ��Ҫ��̬
    static int tick = 20;
    // ����һ����̬Կ��
    static Object ob = "aa";// ֵ�������

    // ��дrun������ʵ����Ʊ����
    @Override
    public void run() {
        while (tick > 0) {
            synchronized (ob) {// �������Ҫ������ʹ��һ������
                // ��ȥ���˻��Կ���������ϣ�������Ű�Կ�����ó���
                if (tick > 0) {
                    System.out.println("��ǰ�߳���"
                            + Thread.currentThread().getName());
                    System.out.println(getName() + "�����˵�" + tick + "��Ʊ");
                    tick--;
                } else {
                    System.out.println("Ʊ������");
                }
            }
            try {
                sleep(1000);// ��Ϣһ��
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

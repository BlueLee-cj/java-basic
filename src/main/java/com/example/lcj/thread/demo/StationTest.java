package com.example.lcj.thread.demo;

public class StationTest {
    /**
     * java���߳�ͬ������ʹ��
     * ʾ����������Ʊ����ͬʱ����10��Ʊ
     */
    public static void main(String[] args) {
        //ʵ����վ̨���󣬲�Ϊÿһ��վ̨ȡ����
        Station station1 = new Station("����1");
        Station station2 = new Station("����2");
        Station station3 = new Station("����3");
        // ��ÿһ��վ̨������Կ�ʼ����
        station1.start();
        station2.start();
        station3.start();
        System.out.println("��ǰ�߳���" + Thread.currentThread().getName());
    }
}


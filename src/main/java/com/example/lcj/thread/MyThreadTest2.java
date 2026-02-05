package com.example.lcj.thread;

public class MyThreadTest2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            MyThread2 myThread2 = new MyThread2();
            myThread2.setName("myThread2");
            myThread2.start();//֪ͨ�̹߳滮�����߳��Ѿ�׼���������ȴ������̶߳����run()����
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main = " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

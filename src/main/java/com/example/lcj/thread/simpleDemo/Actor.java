package com.example.lcj.thread.simpleDemo;

public class Actor extends Thread {

    @Override
    public void run() {
        System.out.println(getName() + "��һ����Ա��");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "��̨�ݳ���" + (++count));
            if (count == 100) {
                keepRunning = false;
            }

            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + "�ݳ�������");
    }

    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.run();
        Actress actress = new Actress();
        Thread actressThread = new Thread(actress);
        actressThread.setName("Ms.Runnable");
        actressThread.start();
    }
}

class Actress implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "��һ����Ա��");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "��̨�ݳ���" + (++count));
            if (count == 100) {
                keepRunning = false;
            }

            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "�ݳ�������");
    }

}

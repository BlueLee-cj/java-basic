package com.example.lcj.thread.syncinfosample01;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/17 15:34
 */
public class Clock {
    private int seconds;
    private int minutes;
    private int hours;

    public Clock(int hours, int minutes, int seconds) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.hours = hours;
    }

    private synchronized void addSecond() {
        this.notifyAll();
        while (seconds == 60) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(hours + ":" + minutes + ":" + seconds);
        seconds++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void addMinute() {
        this.notifyAll();
        while (seconds != 60 || minutes == 60) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        minutes++;
        seconds = 0;
    }

    private synchronized void addHour() {
        this.notifyAll();
        while (minutes != 60) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hours++;
        minutes = 0;
        if (hours == 24) {
            hours = 0;
        }
    }


    Thread t1 = new Thread() {
        public void run() {
            while (true) {
                addSecond();
            }
        }
    };


    Thread t2 = new Thread() {
        public void run() {
            while (true) {
                addMinute();
            }
        }
    };

    Thread t3 = new Thread() {
        public void run() {
            while (true) {
                addHour();
            }
        }
    };

    public void timing() {
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        new Clock(23, 59, 55).timing();
    }


}

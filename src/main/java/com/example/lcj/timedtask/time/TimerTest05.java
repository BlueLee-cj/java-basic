package com.example.lcj.timedtask.time;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 运行结果：timerOne抛出异常，导致timerTwo任务终止。
 */
public class TimerTest05 {
    private Timer timer;

    public TimerTest05() {
        this.timer = new Timer();
    }

    public void timerOne() {
        timer.schedule(new TimerTask() {
            public void run() {
                throw new RuntimeException();
            }
        }, 1000);
    }

    public void timerTwo() {
        timer.schedule(new TimerTask() {

            public void run() {
                System.out.println("我会不会执行呢？？");
            }
        }, 1000);
    }

    public static void main(String[] args) {
        TimerTest05 test = new TimerTest05();
        test.timerOne();
        test.timerTwo();
    }
}

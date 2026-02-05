package com.example.lcj.timedtask.time;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest02 {
    Timer timer;

    public TimerTest02() {
        Date time = getTime();
        System.out.println("指定时间time=" + time);
        timer = new Timer();
        timer.schedule(new TimerTaskTest02(), time);
    }

    public Date getTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 41);
        calendar.set(Calendar.SECOND, 55);
        Date time = calendar.getTime();

        return time;
    }

    public static void main(String[] args) {
        new TimerTest02();
    }
}
 

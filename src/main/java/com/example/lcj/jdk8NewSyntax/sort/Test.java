package com.example.lcj.jdk8NewSyntax.sort;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.lang3.time.DateFormatUtils;

public class Test {
    // 状态
    private int state;
    // 时间
    private Date time;

    // 时间
    private Date time2;

    public Test(int state) {
        this.state = state;
    }

    public Test(int state, Date time) {
        this.state = state;
        this.time = time;
    }

    public Test(int state, Date time, Date time2) {
        this.state = state;
        this.time = time;
        this.time2 = time2;
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime2() {
        return time;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

    @Override
    public String toString() {
        return "Test{" +
                "state=" + state +
                ", time=" + (Objects.isNull(time)
                        ? null
                        : DateFormatUtils.format(time, "yyyy-MM-dd"))
                +
                ", time2=" + (Objects.isNull(time2)
                        ? null
                        : DateFormatUtils.format(time2, "yyyy-MM-dd"))
                +
                '}';
    }
}

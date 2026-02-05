package com.example.lcj.base;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/1/4 9:59
 */
public class Switch {
    enum Season {spring, summer, autumn, winter}

    public static void main(String[] args) {
        Season season = Season.spring;
        switch (season) {
            case spring:
                System.out.println("春暖花开");
                break;
            case summer:
                System.out.println("夏日艳艳");
                break;
            case autumn:
                System.out.println("秋高气爽");
                break;
            case winter:
                System.out.println("残冬腊月");
                break;

        }
    }
}

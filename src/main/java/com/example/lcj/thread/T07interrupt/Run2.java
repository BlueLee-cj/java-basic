package com.example.lcj.thread.T07interrupt;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/8/9 9:11
 */
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1？=" + Thread.interrupted());
        System.out.println("是否停止2？=" + Thread.interrupted());
    }
}

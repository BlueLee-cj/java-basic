package com.example.lcj.thread.threadlocal;

public class InfoUtil {
    private static ThreadLocal<String> nameInfo = new ThreadLocal<>();
    private static ThreadLocal<Integer> ageInfo = new ThreadLocal<>();

    public static void setInfo(String name, Integer age) {
        nameInfo.set(name);
        ageInfo.set(age);
    }

    public static String getName() {
        return nameInfo.get();
    }

    public static void main(String[] args) {
        new Thread(() -> {
            InfoUtil.setInfo("张三", 10);
            // 张三
            System.out.println(InfoUtil.getName());
        }, "thread1").start();
        new Thread(() -> {
            InfoUtil.setInfo("李四", 20);
            // 李四
            System.out.println(InfoUtil.getName());
        }, "thread2").start();
    }
}
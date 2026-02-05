package com.example.lcj.thread.T43_DCL;

/**
 * @author ：lcj
 * @description：单例模式，饿汉式
 * @date ：Created in 2020/4/25 9:11
 */
public class Singe01 {
    private static final Singe01 INSTANCE = new Singe01();
    private Singe01(){}
    public static Singe01 getInstance(){return INSTANCE;}
    public void m() { System.out.println("m");}

    public static void main(String[] args) {
        Singe01 s1 = Singe01.getInstance();
        Singe01 s2 = Singe01.getInstance();
        System.out.println(s1 == s2);
    }
}

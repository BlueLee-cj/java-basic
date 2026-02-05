package com.example.lcj.thread.T43_DCL;

/**
 * @author ：lcj
 * @description：单例模式，懒汉式式
 * @date ：Created in 2020/4/25 9:11
 */
public class Singe02 {
    private static Singe02 INSTANCE;
    private Singe02(){}
    public static Singe02 getInstance(){
        if(INSTANCE == null){
            INSTANCE = new Singe02();
        }
        return INSTANCE;
    }
    public void m() { System.out.println("m");}

    public static void main(String[] args) {
        Singe02 s1 = Singe02.getInstance();
        Singe02 s2 = Singe02.getInstance();
        System.out.println(s1 == s2);
    }
}

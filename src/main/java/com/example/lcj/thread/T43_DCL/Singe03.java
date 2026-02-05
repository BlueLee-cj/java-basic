package com.example.lcj.thread.T43_DCL;

/**
 * @author ：lcj
 * @description：单例模式，懒汉式式,不唯一
 * @date ：Created in 2020/4/25 9:11
 */
public class Singe03 {
    private static Singe03 INSTANCE;
    private Singe03(){}
    public static Singe03 getInstance(){
        if(INSTANCE == null){
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Singe03();
        }
        return INSTANCE;
    }
    public void m() { System.out.println("m");}

    public static void main(String[] args) {
        for (int i=0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Singe03.getInstance().hashCode());
            }).start();
        }
    }
}

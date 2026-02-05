package com.example.lcj.thread.T43_DCL;

/**
 * @author ：lcj
 * @description：单例模式，懒汉式式,锁轻点，只锁业务代码,但还是不行
 * @date ：Created in 2020/4/25 9:11
 */
public class Singe05 {
    private static Singe05 INSTANCE;
    private Singe05(){}
    public static  Singe05 getInstance(){
        if(INSTANCE == null){
            synchronized(Singe05.class){
                try{
                    Thread.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                INSTANCE = new Singe05();
            }
        }
        return INSTANCE;
    }
    public void m() { System.out.println("m");}

    public static void main(String[] args) {
        for (int i=0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Singe05.getInstance().hashCode());
            }).start();
        }
    }
}

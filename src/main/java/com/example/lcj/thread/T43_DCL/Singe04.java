package com.example.lcj.thread.T43_DCL;

/**
 * @author ：lcj
 * @description：单例模式，懒汉式式,锁太重
 * @date ：Created in 2020/4/25 9:11
 */
public class Singe04 {
    private static Singe04 INSTANCE;
    private Singe04(){}
    public static synchronized Singe04 getInstance(){
        if(INSTANCE == null){
            try{
                Thread.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            INSTANCE = new Singe04();
        }
        return INSTANCE;
    }
    public void m() { System.out.println("m");}

    public static void main(String[] args) {
        for (int i=0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Singe04.getInstance().hashCode());
            }).start();
        }
    }
}

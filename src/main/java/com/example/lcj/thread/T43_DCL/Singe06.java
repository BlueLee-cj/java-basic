package com.example.lcj.thread.T43_DCL;

/**
 * @author ：lcj
 * @description：单例模式，懒汉式式,锁轻点，只锁业务代码,双重检查DCL,double check lock,但是有可能指令重排序
 * @date ：Created in 2020/4/25 9:11
 */
public class Singe06 {
    private static Singe06 INSTANCE;
    private Singe06(){}
    public static Singe06 getInstance(){
        if(INSTANCE == null){
            synchronized(Singe06.class){
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singe06();
                }
            }
        }
        return INSTANCE;
    }
    public void m() { System.out.println("m");}

    public static void main(String[] args) {
        for (int i=0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Singe06.getInstance().hashCode());
            }).start();
        }
    }
}

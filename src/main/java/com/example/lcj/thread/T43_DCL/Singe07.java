package com.example.lcj.thread.T43_DCL;

/**
 * @author ：lcj
 * @description：单例模式，懒汉式式,锁轻点，只锁业务代码,双重检查DCL,double check lock,volatile防止指令重排序
 * @date ：Created in 2020/4/25 9:11
 */
public class Singe07 {
    private static volatile Singe07 INSTANCE;
    private Singe07(){}
    public static Singe07 getInstance(){
        if(INSTANCE == null){
            synchronized(Singe07.class){
                if(INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singe07();
                }
            }
        }
        return INSTANCE;
    }
    public void m() { System.out.println("m");}

    public static void main(String[] args) {
        for (int i=0; i < 100; i++){
            new Thread(() -> {
                System.out.println(Singe07.getInstance().hashCode());
            }).start();
        }
    }
}

package com.example.lcj.thread.T215DirtyRead;

/**
 * @author ：lcj
 * @description：
 * @modified By：
 * @date ：Created in 2019/7/20 17:25
 */
public class MyObject {
    public static String userName = "A";
    public static String passWord = "AA";

    synchronized public void setValue(String userName, String passWord) {
        try {
            this.userName = userName;
            Thread.sleep(5000);
            this.passWord = passWord;
            System.out.println(Thread.currentThread().getName() + " setValue  userName=" + this.userName + " passWord=" + this.passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println(Thread.currentThread().getName() + " getValue  userName=" + userName + " passWord=" + passWord);
    }
}

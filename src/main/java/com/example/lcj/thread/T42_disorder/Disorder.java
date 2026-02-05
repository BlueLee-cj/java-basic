package com.example.lcj.thread.T42_disorder;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/24 22:52
 */
public class Disorder {
    static int x;
    static int y;
    static int a;
    static int b;
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;){
            i++;
            x=0;y=0;
            a=0;b=0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread two =  new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();
            two.start();
            one.join();
            two.join();
            String result = "第" + i + "次(" + x + "," + y + ")";
            if( x == 0 && y == 0){
                System.out.println(result);
                break;
            }else {

            }
        }
    }
}

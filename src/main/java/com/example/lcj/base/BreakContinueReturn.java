package com.example.lcj.base;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/1/4 9:49
 */
public class BreakContinueReturn {
    public static void main(String[] args) {
        loop1:
        for (int i = 4; i < 10; i++) {
            loop2:
            switch (i) {
                case 0:
                    break;
                case 1:
                    break loop2;
                case 3:
                    break loop1;
                default:
                    System.out.println("默认值");
            }
        }
    }
}

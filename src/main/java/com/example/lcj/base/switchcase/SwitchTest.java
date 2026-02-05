package com.example.lcj.base.switchcase;

/**
 * @author lichengjian
 * @date 2021/4/8
 */
public class SwitchTest {
    public static void main(String[] args) {
        // char grade = args[0].charAt(0);
        char grade = 'G';

        switch (grade) {
            case 'A':
                System.out.println("优秀");
                break;
            case 'B':
            case 'C':
                System.out.println("良好");
            case 'D':
            case 'E':
                System.out.println("及格");
                break;
            case 'F':
                System.out.println("你需要再努力努力");
                break;
            // default:
            // System.out.println("未知等级");
        }
        System.out.println("你的等级是 " + grade);
    }
}

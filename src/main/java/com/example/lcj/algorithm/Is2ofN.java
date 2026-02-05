package com.example.lcj.algorithm;

import java.util.Scanner;

//判断整数是不是2的阶次方
public class Is2ofN {
    public static boolean check(int sum) {
        boolean flag = true; //判断标志
        while(sum > 1) {
            if (sum % 2 == 0) {
                sum = sum/2;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数:");
        int sum = scanner.nextInt();
        System.out.println(sum + " 是不是2的阶次方：" + check(sum));
    }
}

package com.example.lcj.designpattern.chainOfResponsibilityPattern;


public class RaiseSalary {
    private int num;// 要求提高多少工资

    // 构造函数，要求提高多少工资
    public RaiseSalary(int num) {
        this.num = num;
    }

    // 取得要求提高的工资
    public int GetNum() {
        return num;

    }

    public String toString() {
        return "[要求提高工资" + num + "元的问题]";
    }
}
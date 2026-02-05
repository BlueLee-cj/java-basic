package com.example.lcj.designpattern.chainOfResponsibilityPattern;

public class Main {
    public static void main(String[] args) {

        Support evan = new HR("人力Evan");
        Support kaka = new ZuZhang("组长kaka", 100);//组长最多能解决提高工资100的问题
        Support bingbing = new JingLi("经理bingbing", 500);//经理最多能解决提高工资500的问题
        Support wenwen = new DongShiZhang("董事长wenwen", 1000);//经理最多能解决提高工资500的问题

        //构成一个责任链
        evan.SetNext(kaka).SetNext(bingbing).SetNext(wenwen);

        //发生的要滶提高工资的问题
        for (int i = 50; i < 1200; i += 50) {
            evan.GetTrobule(new RaiseSalary(i));
        }

    }
}
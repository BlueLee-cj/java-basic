package com.example.lcj.designpattern.chainOfResponsibilityPattern;

/**
 * 解决提高工资问题的抽象类
 **/
public abstract class Support {
    private String name;//解决提高工资人的名称
    private Support next;//问题由下一个人来解决

    //提高工资的解决都
    public Support(String name) {
        this.name = name;
    }

    //设定转送位置
    public Support SetNext(Support next) {
        this.next = next;
        return next;
    }

    //解决工资问题的步骤
    public final void GetTrobule(RaiseSalary raisesalary) {
        if (Resolver(raisesalary)) {
            Succecd(raisesalary);
        } else if (next != null) {
            next.GetTrobule(raisesalary);
        } else {
            Fail(raisesalary);
        }

    }

    //打印字符
    public String toString() {

        return "[" + name + "]";
    }

    //解决问题的方法
    protected abstract boolean Resolver(RaiseSalary raisesalary);


    //问题解决,工资得到加
    protected void Succecd(RaiseSalary raisesalary) {
        System.out.println(raisesalary + "由" + this + "解决了。");
    }

    //问题无法解决,
    protected void Fail(RaiseSalary raisesalary) {
        System.out.println(raisesalary + "无法解决");
    }


}
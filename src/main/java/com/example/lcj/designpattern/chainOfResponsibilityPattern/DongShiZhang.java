package com.example.lcj.designpattern.chainOfResponsibilityPattern;

/**
 * 董事长能处理问题
 **/
class DongShiZhang extends Support {
    private int limit;//能提高最大工资的限度

    //构造函数，董事长能处理要求提高多少工资的问题
    public DongShiZhang(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean Resolver(RaiseSalary raisesalary) {
        if (raisesalary.GetNum() <= limit) {
            return true;
        } else {
            return false;
        }
    }

}
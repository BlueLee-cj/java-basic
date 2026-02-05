package com.example.lcj.designpattern.chainOfResponsibilityPattern;


/**
 * 经理能处理问题
 **/
class JingLi extends Support {
    private int limit;//能提高最大工资的限度

    //构造函数，经理能处理要求提高多少工资的问题
    public JingLi(String name, int limit) {
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
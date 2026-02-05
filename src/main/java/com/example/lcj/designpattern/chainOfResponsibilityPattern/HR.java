package com.example.lcj.designpattern.chainOfResponsibilityPattern;

/**
 * HR只能搜集要求提高工资的问题，并将它上报
 **/
class HR extends Support {

    public HR(String name) {
        super(name);
    }

    //HR无法解决要求提高工资的问题
    @Override
    protected boolean Resolver(RaiseSalary raisesalary) {
        // TODO 自动生成的方法存根
        return false;
    }

}
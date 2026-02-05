package com.example.lcj.designpattern.decorator;

/**
 * Decorator装饰角色
 */
class SuperCar implements ICar {
    /**
     * 子类需要使用,所以使用protected
     * 又是一个典型的接口做属性,典型的开闭原则
     */
    protected ICar car;
 
    public SuperCar(ICar car) {
        this.car = car;
    }
 
    /**
     * 原功能两保留
     */
    @Override
    public void move() {
        car.move();
    }
}

package com.example.lcj.designpattern.decorator;

/**
 * ConcreteDecorator具体装饰角色
 */
class FlyCar extends SuperCar {
 
    public FlyCar(ICar car) {
        super(car);
    }
 
    /**
     * 这里进行装饰功能
     */
    public void fly() {
        System.out.println("天上飞！");
    }
 
    @Override
    public void move() {
        super.move();
        //拓展功能,装饰
        fly();
    }
 
}

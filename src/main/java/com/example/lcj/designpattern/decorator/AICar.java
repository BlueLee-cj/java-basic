package com.example.lcj.designpattern.decorator;

/**
 * ConcreteDecorator具体装饰角色
 */
class AICar extends SuperCar {
 
    public AICar(ICar car) {
        super(car);
    }
 
    /**
     * 这里进行装饰功能
     */
    public void autoMove() {
        System.out.println("自动跑！");
    }
 
    @Override
    public void move() {
        super.move();
        //拓展功能,装饰
        autoMove();
    }
 
}
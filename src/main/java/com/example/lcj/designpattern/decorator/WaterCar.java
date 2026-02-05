package com.example.lcj.designpattern.decorator;

/**
 * ConcreteDecorator具体装饰角色
 */
class WaterCar extends SuperCar {
 
    public WaterCar(ICar car) {
        super(car);
    }
 
    /**
     * 这里进行装饰功能
     */
    public void swim() {
        System.out.println("水上游！");
    }
 
    @Override
    public void move() {
        super.move();
        //拓展功能,装饰
        swim();
    }
 
}

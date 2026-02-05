package com.example.lcj.designpattern.decorator;

/**
 * 具体构件角色(真实对象),接口迟早要用于实现的,那这里车就来实现车子移动的接口
 */
class Car implements ICar {
    @Override
    public void move() {
        System.out.println("陆地上跑！");
    }
}

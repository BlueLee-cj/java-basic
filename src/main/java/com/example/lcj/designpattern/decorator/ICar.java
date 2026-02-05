package com.example.lcj.designpattern.decorator;

/**
 * ICar:抽象构建,面向接口编程,不管三七二十一,来个接口明确要干什么哈
 * 就是实现一个毫无装饰的移动的功能
 *
 * @author zhangxiaoxiang
 * @date 2019/8/9
 */
public interface ICar {
    /**
     * 毫无装饰的陆地上跑的功能
     */
    void move();
}
 

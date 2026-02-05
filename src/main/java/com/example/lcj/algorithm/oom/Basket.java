package com.example.lcj.algorithm.oom;

class Basket{
    public String name; //篮子名称
    private Goods goods; //篮子中所装物品
    public Basket(String name) {
        this.name = name;
        System.out.println(name + "篮子被创建");
    }
    //装物品函数
    public void load(String name) {
        goods = new Goods(name);
        System.out.println(this.name + "装载了" + name + "物品");
    }
    public void change(Basket B) {
        System.out.println(this.name + " 和 " + B.name + "中的物品发生了交换");
        String tmp = this.goods.getName();
        this.goods.setName(B.goods.getName());
        B.goods.setName(tmp);
    }
    public void show() {
        System.out.println(this.name + "中有" + goods.getName() + "物品");
    }
}
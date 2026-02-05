package com.example.lcj.designpattern.facade;

/**
 * 不利用设计模式，用代码来模拟这个我们和别人交流接听和理解别人话的过程
 *
 * @author DC
 */
public class TestTradition {

    public static void main(String[] args) {
        //这是我的耳朵和大脑
        Ear ear = new Ear();
        Brain brain = new Brain();

        //别人对我说了句话，我耳朵“听”到了
        String words = ear.getWords("你在干吗？");

        //但是我的耳朵并不理解别人说的什么意思，于是交给我的大脑
        ear.sendWordsToBrain(brain, words);

        //我的大脑分析话语
        brain.explainWords();
    }
}

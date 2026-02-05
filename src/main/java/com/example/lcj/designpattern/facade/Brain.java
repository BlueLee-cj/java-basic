package com.example.lcj.designpattern.facade;

/**
 * @author DC
 */
public class Brain {

    /**
     * 话语
     */
    private String words;

    /**
     * 把话语记录大脑，别人说了话就设置true，反之false
     */
    public boolean sendWordsInBrain(String words) {
        this.words = words;
        if (words == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 分析话语
     */
    public void explainWords() {
        //模拟分析过程
        try {
            System.out.println("正在分析对方说的话是什么意思......");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("额，原来你是这个意思！！");
    }
}

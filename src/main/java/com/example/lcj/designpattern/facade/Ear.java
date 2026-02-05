package com.example.lcj.designpattern.facade;

/**
 * @author DC
 */
public class Ear {

    /**
     * 别人说的话
     */
    private String words;

    /**
     * 听-获取别人说的话
     */
    public String getWords(String words) {
        System.out.println("别人对我说的话：" + words);
        return words;
    }

    /**
     * 耳朵把话传给大脑
     */
    public boolean sendWordsToBrain(Brain brain, String words) {
        return brain.sendWordsInBrain(words);
    }
}

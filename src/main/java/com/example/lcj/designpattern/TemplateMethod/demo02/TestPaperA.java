package com.example.lcj.designpattern.TemplateMethod.demo02;

/**
 * Created by jiangxs on 2018/5/7.
 * <p>
 * 学生甲抄的试卷
 */
public class TestPaperA extends TestPaper {

    @Override
    public String answer1() {
        return "d";
    }

    @Override
    public String answer2() {
        return "c";
    }

    @Override
    public String answer3() {
        return "c";
    }
}
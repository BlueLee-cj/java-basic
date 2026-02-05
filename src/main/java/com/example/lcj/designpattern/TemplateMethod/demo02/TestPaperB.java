package com.example.lcj.designpattern.TemplateMethod.demo02;

/**
 * Created by jiangxs on 2018/5/7.
 * <p>
 * 学生乙抄的试卷
 */
public class TestPaperB extends TestPaper {

    @Override
    public String answer1() {
        return "a";
    }

    @Override
    public String answer2() {
        return "a";
    }

    @Override
    public String answer3() {
        return "a";
    }
}
package com.example.lcj.base.copy;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;


public class TestApacheBeanUtils {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        // 下面只是用于单独测试
        PersonSource personSource = new PersonSource(1, "pjmike", "12345", 21);
        PersonDest personDest = new PersonDest();
        BeanUtils.copyProperties(personSource, personDest);
        System.out.println("persondest: " + personDest);
    }
}

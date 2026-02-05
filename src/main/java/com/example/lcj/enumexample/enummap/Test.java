package com.example.lcj.enumexample.enummap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;

import com.example.lcj.enumexample.SeasonEnum;
import com.example.lcj.jvm.object.Student;
import com.google.common.collect.Lists;

/**
 * @author lichengjian
 * @date 2021/7/20
 */
public class Test {

    public static void main(String[] args) {

        EnumMap<SeasonEnum, ArrayList<Student>> map = new EnumMap<SeasonEnum,  ArrayList<Student>>(SeasonEnum.class);

        ArrayList<Student> arrayList = Lists.newArrayList();
        Student student1 = new Student(1);
        student1.setSeasonEnum(SeasonEnum.SPRING);
        Student student2 = new Student(2);
        student2.setSeasonEnum(SeasonEnum.SUMMER);
        Student student3 = new Student(3);
        student3.setSeasonEnum(SeasonEnum.SUMMER);
        arrayList.add(student1);
        arrayList.add(student2);
        arrayList.add(student3);
        for (Student student : arrayList){
            map.computeIfAbsent(student.getSeasonEnum(), x -> new ArrayList<>()).add(student);
        }

        Collections.emptyMap();

    }
}

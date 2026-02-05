package com.example.lcj.jvm.object;

import com.example.lcj.enumexample.SeasonEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Cloneable, Serializable {

    private int id;

    private SeasonEnum seasonEnum;

    public Student(Integer id) {
        this.id = id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student [id=" + id + "]";
    }
}
package com.example.lcj.spring.cycleDependence.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class XX {

    @Autowired
    YY yy;

    public XX() {
        System.out.println("XX create");
    }

    public void add() {
        System.out.println("XX create");
    }
}

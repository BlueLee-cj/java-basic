package com.example.lcj.spring.cycleDependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/10/18 13:59
 */
//@Scope("prototype")
@Component
public class A {

	private B b;
    //public A(B b) {
    //    this.b = b;
    //}

    @Autowired
    public void setB(B b) {
        this.b = b;
    }

    public B getB() {
        return b;
    }
}

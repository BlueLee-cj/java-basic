package com.example.lcj.spring.bean.DependencyInjection.ConstructorbasedDependencyInjection.demo02xml;

import org.springframework.stereotype.Component;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/11/22 22:39
 */
@Component
public class ADemo {

    //@Autowired
    XDemo xDemo;
    YDemo yDemo;
    //
    //@Autowired
    //Y y;

    //@Autowired
    //I ix;

    //@Autowired
    //I i;

    //@Autowired
    //public void setXX(X x) {
    //    this.x = x;
    //}

    //public void setX(X x) {
    //    this.x = x;
    //}

    public ADemo(){

    }

    public void setXxx(XDemo xDemo){
        this.xDemo = xDemo;
    }

    public ADemo(XDemo xDemo, YDemo yDemo){
        System.out.println("x-y");
        this.xDemo = xDemo;
    }

    public void setyDemo(YDemo yy){
        this.yDemo = yDemo;
    }

    public void print(){
        System.out.println(xDemo);
        xDemo.call();
        //System. out.println(y);
        //y.call();
        //System.out.println(ix);
        //ix.call();
        //System.out.println(i);
        //i.call();
        System.out.println(yDemo);
        yDemo.call();
    }
}

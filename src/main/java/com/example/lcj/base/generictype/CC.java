package com.example.lcj.base.generictype;

public class CC<T> {

    private T ob;


    public CC(T ob) {
        super();
        this.ob = ob;
    }

    public T getOb() {
        return ob;
    }

    public void setOb(T ob) {
        this.ob = ob;
    }

    public void print() {
        System.out.println("xxxx" + ob.getClass().getName());
    }

}

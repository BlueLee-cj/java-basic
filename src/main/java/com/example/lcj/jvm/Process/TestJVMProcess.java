package com.example.lcj.jvm.Process;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/19 13:18
 */
public class TestJVMProcess {
    public static void main(String[] args) {
        TestJVMProcess test = new TestJVMProcess();
        Person p = new Person("lcj", 12);
        BirthDate d = new BirthDate(1990, 5, 20,p);
        test.change(d);
        System.out.println(d);
        test.change1(d);
        System.out.println(d);

    }

    public void change(BirthDate b){
        Person ldy = new Person("ldy", 12);
        b = new BirthDate(2020,4,19,ldy);
    }

    public void change1(BirthDate b){
        b.setDate(7);
        Person p = b.getP();
        changeP(p);
        p = new Person("ldy",12);
        b.setP(p);
    }

    public static void changeP(Person p){
        p = new Person("ldy",12);
    }

}

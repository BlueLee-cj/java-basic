package com.example.lcj.enumexample.complex;

/**
 * 首先，我们在每个枚举变量的后面加上了一个括号，里面是我们希望它代表的数字。
 * <p>
 * 然后，我们定义了一个int变量，然后通过构造函数初始化这个变量。
 * <p>
 * 你应该也清楚了，括号里的数字，其实就是我们定义的那个int变量。这句叫做自定义变量。
 * 请注意：这里有三点需要注意：
 * <p>
 * 一定要把枚举变量的定义放在第一行，并且以分号结尾。
 * <p>
 * 构造函数必须私有化。事实上，private是多余的，你完全没有必要写，因为它默认并强制是private，如果你要写，也只能写private，写public是不能通过编译的。
 * <p>
 * 自定义变量与默认的ordinal属性并不冲突，ordinal还是按照它的规则给每个枚举变量按顺序赋值。
 */
public enum Weekday {
    MON(1), TUS(2), WED(3), THU(4), FRI(5), SAT(6), SUN(0);

    private int value;

    private Weekday(int value) {
        this.value = value;
    }
}
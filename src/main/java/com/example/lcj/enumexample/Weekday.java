package com.example.lcj.enumexample;

public enum Weekday {
    //使用的是enum关键字而不是class。
    //多个枚举变量直接用逗号隔开。
    //枚举变量最好大写，多个单词之间使用”_”隔开（比如：INT_SUM）。
    //定义完所有的变量后，以分号结束，如果只有枚举变量，而没有自定义变量，分号可以省略（例如上面的代码就忽略了分号）。
    //在其他类中使用enum变量的时候，只需要【类名.变量名】就可以了，和使用静态变量一样。
    SUN(0), MON(1), TUS(2), WED(3), THU(4), FRI(5), SAT(6);

    private int value;

    private Weekday(int value) {
        this.value = value;
    }

    public static Weekday getNextDay(Weekday nowDay) {
        int nextDayValue = nowDay.value;

        if (++nextDayValue == 7) {
            nextDayValue = 0;
        }

        return getWeekdayByValue(nextDayValue);
    }

    public static Weekday getWeekdayByValue(int value) {
        for (Weekday c : Weekday.values()) {
            if (c.value == value) {
                return c;
            }
        }
        return null;
    }
}
 


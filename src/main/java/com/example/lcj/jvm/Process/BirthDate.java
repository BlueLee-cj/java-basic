package com.example.lcj.jvm.Process;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2020/4/19 13:21
 */
public class BirthDate
{
    private int year;
    private int date;
    private int day;
    private Person p;

    @Override
    public String toString() {
        return "BirthDate{" +
                "year=" + year +
                ", date=" + date +
                ", day=" + day +
                ", p=" + p +
                '}';
    }

    public BirthDate(int year, int date, int day, Person p) {
        this.year = year;
        this.date = date;
        this.day = day;
        this.p = p;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public Person getP() {
        return p;
    }

    public void setP(Person p) {
        this.p = p;
    }
}

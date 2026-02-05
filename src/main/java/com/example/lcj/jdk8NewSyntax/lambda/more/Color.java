package com.example.lcj.jdk8NewSyntax.lambda.more;

public enum Color {
    GREEN(0, "green"), RED(1, "red");

    int value;
    String name;

    Color(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}

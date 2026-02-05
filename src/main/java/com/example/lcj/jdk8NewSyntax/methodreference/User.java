package com.example.lcj.jdk8NewSyntax.methodreference;

import lombok.Data;

@Data
public class User {
    private String username;
    private Integer age;

    public User() {}

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    // Getter&Setter
}

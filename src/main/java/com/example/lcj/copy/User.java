package com.example.lcj.copy;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户
 */
@Data
@NoArgsConstructor
public class User {

    private String name;
    private Address address;
    private int age;

    public User(String name, Address address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

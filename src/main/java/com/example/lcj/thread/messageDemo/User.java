package com.example.lcj.thread.messageDemo;

public class User {
    private String ID;
    private String name;

    public User() {
        super();
    }

    public User(String ID, String name) {
        this();
        this.ID = ID;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [ID=" + ID + ", name=" + name + "]";
    }
}

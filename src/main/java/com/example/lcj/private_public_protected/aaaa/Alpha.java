package com.example.lcj.private_public_protected.aaaa;

public class Alpha {
    public void test() {
        this.pub();
        this.pro();
        this.def();
        this.pri();
    }

    public void pub() {
        System.out.println("public");
    }

    protected void pro() {
        System.out.println("protected");
    }

    void def() {
        System.out.println("default");
    }

    private void pri() {
        System.out.println("private");
    }
}

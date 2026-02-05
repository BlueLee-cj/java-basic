package com.example.lcj.jvm.oom;

public class OomMain {
    public static void main(String[] args) {
        OomService service = new OomService();

        while (true) {
            service.addData();
        }
    }
}

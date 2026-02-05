package com.example.lcj.spi;

import java.sql.DriverManager;
import java.util.ServiceLoader;

public class SPIMain {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
        DriverManager.println("xx");
    }
}

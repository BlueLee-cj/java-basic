package com.example.lcj.thread.syncsample;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/17 11:36
 */
public class Guest extends Thread {
    Plate plate;

    public Guest(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        while (true) {
            plate.get();
        }
    }
}

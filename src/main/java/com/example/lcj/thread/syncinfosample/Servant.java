package com.example.lcj.thread.syncinfosample;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/17 11:37
 */
public class Servant extends Thread {
    private Plate plate;

    public Servant(Plate plate) {
        this.plate = plate;
    }

    @Override
    public void run() {
        while (true) {
            plate.put();
        }
    }
}

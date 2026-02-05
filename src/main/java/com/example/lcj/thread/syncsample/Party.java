package com.example.lcj.thread.syncsample;

/**
 * @author ：lcj
 * @description：
 * @date ：Created in 2019/11/17 11:39
 */
public class Party {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Guest guest = new Guest(plate);
        Servant servant = new Servant(plate);
        guest.setName("客人");
        servant.setName("服务员");
        servant.start();
        guest.start();

    }
}

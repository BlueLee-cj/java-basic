package com.example.lcj.base.typeconvert.upcasting;

/**
 * @author lichengjian
 * @date 2023/12/24
 */
public class Instrument {
    public void play(){
        System.out.println("play");
    }
    static void tune(Instrument i){
        i.play();
    }
}

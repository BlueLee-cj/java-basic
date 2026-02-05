package com.example.lcj.thread.transition;

public class Work {
    public void process(Data data, Integer... numbers) {
        for (Integer n : numbers) {
            data.value += n;
        }
    }
}

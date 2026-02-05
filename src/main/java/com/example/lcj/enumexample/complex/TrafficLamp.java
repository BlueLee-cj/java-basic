package com.example.lcj.enumexample.complex;

public enum TrafficLamp {
    /**
     * TrafficLamp RED = new TrafficLamp（30）{
     *
     * @Override public TrafficLamp getNextLamp() {
     * return GREEN;
     * }
     * }
     */
    RED(30) {
        @Override
        public TrafficLamp getNextLamp() {
            return GREEN;
        }
    }, GREEN(45) {
        @Override
        public TrafficLamp getNextLamp() {
            return YELLOW;
        }
    }, YELLOW(5) {
        @Override
        public TrafficLamp getNextLamp() {
            return RED;
        }
    };

    private int time;

    private TrafficLamp(int time) {
        this.time = time;
    }

    //一个抽象方法
    public abstract TrafficLamp getNextLamp();

}
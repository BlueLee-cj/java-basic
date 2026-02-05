package com.example.lcj.designpattern.observerPattern.demo02pull;

import java.util.Observable;

/**
 * 数据提供者
 */
public class WeatherData extends Observable {

    // 三个数据
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
    }

    public void measurementChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
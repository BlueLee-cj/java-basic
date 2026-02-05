package com.example.lcj.designpattern.observerPattern.demo02pull;

import java.util.Observable;
import java.util.Observer;

/**
 * @author wb-xp570304 on 2019/7/9
 */
public class NowConditionDisplay implements Observer {

    Observable observable;
    private float temperature;
    private float humidity;

    public NowConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }

    public void display() {
        System.out.println("当前温度: " + temperature + " 湿度: " + humidity);
    }
}
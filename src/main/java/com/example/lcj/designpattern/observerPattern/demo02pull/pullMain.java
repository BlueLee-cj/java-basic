package com.example.lcj.designpattern.observerPattern.demo02pull;

public class pullMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        NowConditionDisplay nowConditionDisplay = new NowConditionDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30f);
    }
}
//控制台显示：　　当前温度: 80.0 湿度: 65.0
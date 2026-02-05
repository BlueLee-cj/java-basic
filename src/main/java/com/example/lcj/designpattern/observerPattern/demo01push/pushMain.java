package com.example.lcj.designpattern.observerPattern.demo01push;

public class pushMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        NowConditionDisplay nowConditionDisplay = new NowConditionDisplay(weatherData);

        weatherData.setMeasurements(20, 10, 29.2f);
    }
}

//
//控制台显示：
//[push] 当前温度:20.0 当前湿度: 10.0
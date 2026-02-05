package com.example.lcj.designpattern.adapter.demo01;

/**
 * 适配器接口，
 * 其中 support() 方法用于检查输入的电压是否与适配器匹配，
 * outputDC5V() 方法则用于将输入的电压变换为 5V 后输出
 */
public interface DC5Adapter {
    boolean support(AC ac);

    int outputDC5V(AC ac);
}

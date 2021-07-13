package com.study.factory.method;

import com.study.factory.simple.CarFactory;

public class Consumer {

    public static void main(String[] args) {
        Car car = new WuLingFactory().getCar();
        Car car2 = new TeslaFactory().getCar();
        Car car3 = new MoBaiFactory().getCar();

        car.name();
        car2.name();
        car3.name();

        //根据设计原则：工厂方法模式
        //根据实际业务: 简单方法模式

    }

}

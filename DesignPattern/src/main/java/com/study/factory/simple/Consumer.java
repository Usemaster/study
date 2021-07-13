package com.study.factory.simple;

public class Consumer {

    public static void main(String[] args) {
//        Car car = new WuLing();
//        Car car2 = new Tesla();
//
//        car.name();
//        car2.name();

        //使用工厂创建
        Car car = CarFactory.getCar("五菱");
        Car car2 = CarFactory.getCar("特斯拉");

        car.name();
        car2.name();

    }

}

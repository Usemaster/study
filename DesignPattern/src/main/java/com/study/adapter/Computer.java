package com.study.adapter;

//客户端类：想上网，插不上网线
public class Computer {

    public void net(NetToUsb adapter){
        //上网的具体实现，找一个转接头
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        //电脑 适配器 网线
        Computer computer = new Computer();
        Adapter adapter = new Adapter();
        computer.net(adapter);

        System.out.println("========================");

        Adaptee adaptee = new Adaptee();
        Adapter2 adapter2 = new Adapter2(adaptee);
        computer.net(adapter2);

    }

}

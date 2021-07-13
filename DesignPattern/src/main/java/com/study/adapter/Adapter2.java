package com.study.adapter;

//1.继承（类适配器,单继承）
//2.组合 (对象适配器：常用)
//真正的适配器 需要连接USB，连接网线
public class Adapter2 implements NetToUsb{

    private Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void handleRequest() {
        adaptee.request();//可以上网了
    }
}

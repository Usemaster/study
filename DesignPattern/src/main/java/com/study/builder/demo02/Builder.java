package com.study.builder.demo02;

//建造者
public abstract class Builder {

    abstract Builder builderA(String msg);//汉堡
    abstract Builder builderB(String msg);//可乐
    abstract Builder builderC(String msg);//薯条
    abstract Builder builderD(String msg);//甜品

    abstract Product getProduct();

}

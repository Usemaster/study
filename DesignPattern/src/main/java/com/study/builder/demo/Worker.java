package com.study.builder.demo;

//具体的建造者：工人
public class Worker extends Builder{

    private Product product;

    public Worker() {
        product = new Product();
    }

    @Override
    void buildA() {
        product.setBuilderA("地基");
        System.out.println("地基");
    }

    @Override
    void buildB() {
        product.setBuilderB("钢筋工程");
        System.out.println("钢筋工程");
    }

    @Override
    void buildC() {
        product.setBuilderC("铺电线");
        System.out.println("铺电线");
    }

    @Override
    void buildD() {
        product.setBuilderD("粉刷");
        System.out.println("粉刷");
    }

    @Override
    Product getProduct() {
        return product;
    }
}

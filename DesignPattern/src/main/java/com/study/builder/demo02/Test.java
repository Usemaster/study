package com.study.builder.demo02;

public class Test {

    public static void main(String[] args) {
        //服务员
        Worker worker = new Worker();
        //链式编程 在原有的基础上，可以自由组合了
        Product product = worker
                .builderA("全家桶")
                .builderB("雪碧")
                .getProduct();

        System.out.println(product.toString());
    }

}

package com.study.test;

public class Client {

    public static void main(String[] args) {
        Father son = new Son();
        Son son1 = new Son();
        son1.setId("100");
        System.out.println(son1.id);
        son.setName("zs");
        son.setAge(18);
        son.setMoney("100000000");
        System.out.println(son.getAge());
        System.out.println(son.getName());
        System.out.println(son.getMoney());

    }

}

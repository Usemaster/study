package com.study.test;

public class Son extends Father{

    public String id;

    public Son() {
    }

    public Son(String name, int age, String money, String name1, int age1) {
        super(name, age, money);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

package com.study.homework;

import java.util.Objects;
import java.util.TreeSet;

public class HomeWork02 {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        //分析源码
        //add方法，因为TreeSet()构造器没有传入Comparator接口的内名内部类
        //所以在底层 Comparable<? super K> k = (Comparable<? super K>) key;
        //即把Person转成Comparable类型
        //ClassCastException: Person cannot be cast to java.lang.Comparable
        treeSet.add(new Person(1001,"AA"));//ClassCastException

    }

}

class Person{
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

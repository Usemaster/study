package com.study.set_;

import java.awt.image.renderable.RenderableImage;
import java.util.HashSet;
import java.util.Objects;

/*
* 定义一个Employee类，该类包含:private成员属性name,age 要求:
* 1.创建3个Employee对象放入 HashSet中
* 2.当name和age的值相同时，认为是相同员工,不能添加到HashSet集合中
*
* 定义一个Employee类,该类包含:private成员属性name,sal,birthday(MyDate类.型),其中 birthday 为 MyDate类型(属性包括:year, month, day),要求:
* 1.创建3个Employee 放入HashSet中
* 2.当name和birthday的值相同时，认为是相同员工,不能添加到HashSet集合中
*
* */
public class HashSetExercise {

    public static void main(String[] args) {

        HashSet set = new HashSet();
        set.add(new Employee("john",16,new MyDate(2000,12,17)));
        set.add(new Employee("john",16,new MyDate(2000,12,17)));
        set.add(new Employee("john",16,new MyDate(2000,12,17)));

//        for (Object o : set) {
//            System.out.println(o);
//        }

        System.out.println("hashSet=" + set);


    }

}

class Employee{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }
}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year && month == myDate.month && day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}

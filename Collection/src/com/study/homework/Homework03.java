package com.study.homework;

import java.util.HashSet;

public class Homework03 {

    public static void main(String[] args) {

        HashSet set = new HashSet();
        Person p1 = new Person(1001, "AA");//加入
        Person p2 = new Person(1002, "BB");//加入
        set.add(p1);
        set.add(p2);
        p1.setName("CC");
        set.remove(p1);//没有删除成功,找不到位置
        System.out.println(set);
        set.add(new Person(1001,"CC"));//加入
        System.out.println(set);
        set.add(new Person(1001,"AA"));//加入
        System.out.println(set);

        //打印出四个元素

    }

}



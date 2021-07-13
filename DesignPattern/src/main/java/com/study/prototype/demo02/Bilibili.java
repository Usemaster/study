package com.study.prototype.demo02;

import java.util.Date;

/*
* 客户端： 克隆
* */
public class Bilibili {

    public static void main(String[] args) throws CloneNotSupportedException {
        //浅克隆
        //原型对象 v1
        Date date = new Date();
        Video v1 = new Video("狂神说Java", date);
        //v1 克隆 v2
        Video v2 = (Video) v1.clone();

        System.out.println("v1=>"+v1);
        System.out.println("v1=>"+v2);

        System.out.println("===========================");
        date.setTime(22131231);
        System.out.println("v1=>"+v1);
        System.out.println("v1=>"+v2);





    }
}

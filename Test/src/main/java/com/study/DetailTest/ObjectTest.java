package com.study.test01;

/*
* 基本类型和应用类型的引用问题
* */
public class ObjectTest {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a,b);
        System.out.println(a + "," + b);//AB,B
    }

    public static void operator(StringBuffer x,StringBuffer y){
        x.append(y); y = x;
    }

}

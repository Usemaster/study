package com.study.test01;

/*
* final关键字使用
* */
public class FinalTest {

    //成员变量用final修饰要赋值
//    final int a;
    final int a = 10;

    public final void hello(){
        String s = "hello";
        System.out.println(s);
    }

    public static void main(String[] args) {
        //局部变量用final修饰不用初始化
        final int a;
    }

}

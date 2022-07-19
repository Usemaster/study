package com.study.DetailTest;

/*
* final关键字使用
* */
public class FinalTest {

    //成员变量用final修饰要赋值
//    final int a;
    final int a = 10;
    //被final修饰的成员变量要初始化，
    //如果不初始化，也可以在构造函数中初始化
    final int i;
    FinalTest(){
        i = 1;
    }

    public final void hello(){
        String s = "hello";
        System.out.println(s);
    }

    public static void main(String[] args) {
        //局部变量用final修饰不用初始化
        final int a;
    }

}

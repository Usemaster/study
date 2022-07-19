package com.study.nowcoder;

public class Test01{
    static{
        int x=5;//局部变量
    }
    static int x,y;//静态变量
    public static void main(String args[]){
        x--;//-1
        myMethod();
        System.out.println(x+y+ ++x);//3
    }
    public static void myMethod( ){
        y=x++ + ++x;//x = 1  y = 0
    }
}


package com.study.DetailTest;

/*
* 基本类型和应用类型的引用问题
* */
public class ObjectTest {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        //a，b指向的内存地址不变
        operator(a,b);
        //结果还是a，b的内存地址
        System.out.println(a + "," + b);//AB,B
    }

    //x指向a的内存地址，y执行b的内存地址，方法结束后局部变量被GC
    public static void operator(StringBuffer x,StringBuffer y){
        x.append(y); y = x;
    }

}

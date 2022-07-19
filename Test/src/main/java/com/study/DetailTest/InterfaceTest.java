package com.study.DetailTest;

//接口注意事项
public interface InterfaceTest {

    //方法

    //接口中方法被public abstract修饰，所以没有方法体
    void  print();

    //Static methods in interfaces should have a body
    //在接口中静态方法要有方法体
    static void print1(){};

    abstract void print2();

    //变量
    //在接口中变量被public static final修饰，所以要初始化
    static int a = 1;

    

    int b = 2;

}

package com.study.nowcoder;

public interface InterfaceClass {

    //接口中不能有构造函数
    //public Status(){};

    //接口中成员变量是被public static final修饰，要初始化
    //被final修饰是常量
    public static final int a = 1;

    //接口中可以有静态方法
    static void test(){};

}

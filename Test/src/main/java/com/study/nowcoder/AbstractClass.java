package com.study.nowcoder;

public abstract class AbstractClass {

    //抽象类中有成员变量,可以用各种访问修饰符
    protected int a;

    //抽象类可以有构造函数,接口中不能有构造函数
    //构造函数用public修饰，没有返回值
    public AbstractClass() {
    }

    //抽象类中可以有静态方法
    public static void test(){};

}

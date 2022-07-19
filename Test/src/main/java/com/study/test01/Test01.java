package com.study.test01;

class Base
{
    public void method()
    {
        System.out.println("Child");
    }
}
class Son01 {
    public void method()
    {
        System.out.println("Son01");
    }

    public void methodB()
    {
        System.out.println("SonB");
    }
}
public class Test01
{
    public static void main(String[] args)
    {
//        Child base = new Son01();
//        base.method();
        //这句new了一个派生类，赋值给基类，所以下面的操作编译器认为base对象就是Base类型的
        //Base类中不存在methodB()方法，所以编译不通过
        //base.methodB();
    }

}

package com.study.test01;

public class B
{
    public static B t1 = new B();
    public static B t2 = new B();


    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }

    public void  test1(A a){
        a.age = 20;
        System.out.println("test1中的age" + a.age);
    }

    public static void main(String[] args)
    {
        B b = new B();
        A a = new A();
        b.test1(a);
        System.out.println("main中的age" + a.age);
    }
}
class A{
    public int age = 0;
}


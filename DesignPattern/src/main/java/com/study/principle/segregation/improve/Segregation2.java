package com.study.principle.segregation.improve;

/*
* 接口隔离原则
* */
public class Segregation2 {

    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());//A类通过接口去依赖B类
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());//C类通过接口去依赖(使用)D类
        c.depend4(new D());
        c.depend5(new D());
    }
}

interface Interface1{
    void operation1();
}


interface Interface2{
    void operation2();
    void operation3();
}

interface Interface3{
    void operation4();
    void operation5();
}


class B implements Interface1,Interface2{

    @Override
    public void operation1() {
        System.out.println("B实现了operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B实现了operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B实现了operation3");
    }

}

class D implements Interface1,Interface3{

    @Override
    public void operation1() {
        System.out.println("D实现了operation1");
    }


    @Override
    public void operation4() {
        System.out.println("D实现了operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D实现了operation5");
    }
}

class A {//A类通过接口Interface1,2依赖使用B类，但只会用到1，2，3方法
    public void depend1(Interface1 i){
        i.operation1();
    }

    public void depend2(Interface2 i){
        i.operation2();
    }

    public void depend3(Interface2 i){
        i.operation3();
    }

}

class C {//C类通过接口Interface1,3依赖使用D类，但只会用到1，4，5方法
    public void depend1(Interface1 i){
        i.operation1();
    }

    public void depend4(Interface3 i){
        i.operation4();
    }

    public void depend5(Interface3 i){
        i.operation5();
    }

}
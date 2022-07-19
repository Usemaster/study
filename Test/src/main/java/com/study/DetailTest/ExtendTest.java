package com.study.DetailTest;

public class ExtendTest {

    public static void main(String[] args) {
        //父类对象指向子类对象
        //编译看左边，运行看右边
        Animal a = new Dog();

        //a.bark();编译时a是动物类没有bark方法，编译报错
        //运行时是Dog类，Dog类重写了move方法，所以调用Dog的move方法
        a.move();//狗可以跑和走
    }

}

class Dog extends Animal{

    public void move(){
        System.out.println("狗可以跑和走");
    }

    public void bark(){
        System.out.println("狗可以吠叫");
    }

}

class Animal{

    public void move(){
        System.out.println("动物可以移动");
    }



}

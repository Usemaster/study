package com.study.nowcoder;

class Animal{
    public void move(){
        System.out.println("动物可以移动");
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
public class TestDog{
    public static void main(String args[]){
        Animal a = new Animal();
        Animal b = new Dog();
//        Dog d = new Dog();
//        Animal a1 = (Animal)d;
//        a1.move();//狗可以跑和走
        a.move();
        b.move();
        //编译看左边运行看右边。父类型引用指向子类型对象，无法调用只在子类型里定义的方法
        //编译错误
        //Cannot resolve method 'bark' in 'Animal'
        //b.bark();
    }
}
package com.study.nowcoder;

/*
* 子类重写父类的方法，使用的是子类的方法
* */
class A {
    public int func1(int a, int b) {
        return a - b;
    }
}
class B extends A {
    public int func1(int a, int b) {
        return a + b;
    }
}
public class ChildClass {
    public static void main(String[] args) {
        A a = new B();
        B b = new B();
        System.out.println("Result=" + a.func1(100, 50));
        System.out.println("Result=" + b.func1(100, 50));
    }
}

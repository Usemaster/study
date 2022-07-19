package com.study.DetailTest;

//如果子类没有重写父类的方法，调用父类的方法用不用super关键字结果都一样。
//如果子类重写父类的方法，调用父类的方法必须用super关键字。
class TestA{
    public void a(){
        System.out.println("this is TestA a method");
    }

    public void b(){
        System.out.println("this is TestA b method");
    }
}

public class TestC extends TestA{
    //重写父类b方法
    public void b(){
        System.out.println("this is TestC b method");
    }

    public void aa(){
        super.a();
        a();
    }

    public void bb(){
        super.b();
        b();
    }

    public static void main(String[] args) {
        TestC tc = new TestC();
        tc.aa();
        tc.bb();
        //this is TestA a method
        //this is TestA a method
        //this is TestA b method
        //this is TestC b method
    }
}
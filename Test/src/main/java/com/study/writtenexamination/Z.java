package com.study.writtenexamination;

/*
Java程序初始化顺序
* */
class X{
    Y y = new Y();
    public X(){
        System.out.println("X");
    }
}

class Y{
    public Y(){
        System.out.println("Y");
    }
}

public class Z extends X{
    Y y = new Y();

    public Z(){
        System.out.println("Z");
    }

    public static void main(String[] args) {
        //Java程序初始化顺序：
        //父类的静态代码块
        //子类的静态代码块
        //父类的普通代码块
        //父类的构造方法
        //子类的普通代码块
        //子类的构造方法
        new Z();//YXYZ
    }

}

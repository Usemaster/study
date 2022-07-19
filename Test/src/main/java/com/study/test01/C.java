package com.study.test01;

public class C  {

    C(){
        System.out.println("BASE");
    }


    public static void main(String[] args) {
        new D();
        new C();
    }

}
class D extends C{

}
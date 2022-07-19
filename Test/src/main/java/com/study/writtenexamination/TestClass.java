package com.study.writtenexamination;


public class TestClass {


    private static void testMethod(){
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        ((TestClass)null).testMethod();
        String s = "abc";
        Integer b = 1;
        change(s,b);
        System.out.println("s= " + s + " b= " + b);
    }

    public static void change(String a,Integer b){
        a = "123";
        b = 2;
    }



}

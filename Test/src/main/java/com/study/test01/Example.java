package com.study.test01;

public class Example {
    String str = new String("tarena");
    char[] ch = {'a','b','c'};

    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and ");
        System.out.println(ex.ch);
    }

    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'g';
    }
}

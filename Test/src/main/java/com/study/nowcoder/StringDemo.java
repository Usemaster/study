package com.study.nowcoder;

public class StringDemo{
    private static final String MESSAGE="taobao";
    public static void main(String [] args) {
        String a ="tao"+"bao";
        String b="tao";
        String c="bao";
        System.out.println(a==MESSAGE);//true
        System.out.println((b+c)==MESSAGE);//false
    }
}

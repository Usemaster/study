package com.study.DetailTest;

public class TypeTest {

    public static void main(String[] args) {
        Integer a = 128;
        Integer b = new Integer(128);
        Integer c = new Integer(128);
        Integer b1 = new Integer(127);
        Integer c1 = 127;
        Integer d1 = 127;
        int d = 128;

        System.out.println(a == d);//true
        System.out.println(c == d);//true
        System.out.println(b1 == c1);//false
        System.out.println(c1 == d1);//true


    }

}

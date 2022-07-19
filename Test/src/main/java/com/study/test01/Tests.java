package com.study.test01;

public class Tests {

    public static void main(String[] args) {
        Integer i1 = 130;
        int i2 = 130;
        System.out.println("flag1:" + (i1 == i2));

        Integer i3 = 130;
        Integer i4 = 130;
        System.out.println("flag4:" + (i3 == i4));

        Integer i5 = new Integer(13);
        Integer i6 = new Integer(13);
        System.out.println("flag2:" + (i5 == i6));

        Integer i7 = 13;
        Integer i8 = 13;
        System.out.println("flag3:" + (i7 == i8));


    }

}

package com.study.writtenexamination;

import java.util.List;

public class Test {


    public static void main(String[] args) {
        int i = 0;
        Integer j = new Integer(0);
        System.out.println(i == j);//true
        System.out.println(j.equals(i));//true

        //String是final类型，只能赋值一次
        String lx = "LeXin";
        String nb = lx;//把nb指向lx的内存地址
        lx = "Fenqile";//lx重新创建了一个String
        System.out.println(nb);//LeXin

        int Array_a[] = new int[10];
        //System.out.println(Array_a[10]);//ArrayIndexOutOfBoundsException
        System.out.println(Student.age);

        int b = 1;
        set(b);
    }

    public static void set(int b){
        b = 2;
        System.out.println(b);
    }

}
class Student{
    static {
        age = 23;
    }

    public static int age;

    //编译错误 Unknown class: 'age'
    //age = 30;
}

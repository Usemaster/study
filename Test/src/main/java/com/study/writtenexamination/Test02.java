package com.study.writtenexamination;

public class Test02 {

    public static void main(String[] args) {
        long a = 100L;
        a += 100;
        int b = 100;
        //编译错误，类型转换异常
        //b = b + a++;
        System.out.println((a++) + "、" + (++b));
    }

}

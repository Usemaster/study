package com.study.nowcoder;

public class EqualsTest {

    public static void main(String[] args) {
        Integer i1 = 128;
        Integer i2 = 128;
        //-128-127在常量池可以找到，大于127会new一个对象
        System.out.print((i1 == i2) + ",");
        String i3 = "100";
        //栈中先创建一个"a"字符串常量，再创建一个"bc"字符串常量，
        //编译阶段不会进行拼接，在运行阶段拼接成"abc"字符串常量并将s的引用指向它，效果相当于String s = new String("abc")，
        //只有'+'两边都是字符串常量才会在编译阶段优化
        String i4 = "1" + new String("00");
        System.out.print((i3 == i4) + ",");
        Integer i5 = 100;
        Integer i6 = 100;
        System.out.println((i5 == i6));
    }

}

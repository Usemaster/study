package com.study.standard;

import java.util.Scanner;

public class InputAndOutput {

    public static void main(String[] args) {
        //System类的public final static InputStream in = null;
        //System.in 编译类型 InputStream
        //System.in 运行类型 BufferedInputStream
        //表示的是标准输入 键盘
        System.out.println(System.in.getClass());

        //System类的public final static PrintStream out = null;
        //System.out 编译类型 PrintStream
        //System.out 运行类型 PrintStream
        //表示的是标准输出 显示器
        System.out.println(System.out.getClass());

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入内容");
        String next = scanner.next();
        System.out.println("next = " + next);



    }

}

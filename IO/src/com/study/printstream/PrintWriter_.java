package com.study.printstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//演示使用PrintWriter
public class PrintWriter_ {

    public static void main(String[] args) throws IOException {

        //显示器输出
        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.print("hi,北京你好");
        printWriter.close();

    }

}

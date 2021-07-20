package com.study.printstream;

import java.io.IOException;
import java.io.PrintStream;

//演示PrintStream（字节打印流）
public class PrintStream_ {

    public static void main(String[] args) throws IOException {

        PrintStream out = System.out;
        //在默认情况下，PrintStream输出数据的位置是 标准输出，即显示器
        /*
        *    public void print(String s) {
                if (s == null) {
                    s = "null";
             }
             write(s);
        * */
        out.print("jhon,hello");
        //因为print底层使用的是write，所以我们可以直接使用print进行打印/输出
        out.write("hi,world".getBytes());
        out.close();

        //我们可以去修改打印流输出的位置/设备
        //修改输出位置到e:\f1.txt
        /*
        *     public static void setOut(PrintStream out) {
                    checkIO();
                    setOut0(out);  //native方法
              }
        * */
        System.setOut(new PrintStream("e:\\f1.txt"));
        System.out.println("hello,usemaster");


    }

}

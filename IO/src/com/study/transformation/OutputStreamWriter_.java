package com.study.transformation;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;

//演示OutputStreamWriter使用
//把FileOutputStream字节流，转换成字符流OutputStreamWriter
//指定编码gbk/utf-8/utf8
public class OutputStreamWriter_ {

    public static void main(String[] args) throws Exception{

        String filePath = "e:\\notes.txt";

        String charSet = "utf8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hi,世界");
        osw.close();
        System.out.println("按照" + charSet + "保存文件成功");

    }

}

package com.study.transformation;

import java.io.*;
import java.nio.charset.StandardCharsets;

//看一个中文乱码问题
public class CodeQuestion {

    public static void main(String[] args) throws Exception{

        //读取e:\\note.txt文件到程序
        //默认情况下，读取文件是按照utf-8编码
        String filePath = "e:\\note.txt";
        BufferedReader br = new BufferedReader(new FileReader(filePath));

        String s = br.readLine();
        System.out.println("读取到的内容:" + s);

        br.close();

    }

}

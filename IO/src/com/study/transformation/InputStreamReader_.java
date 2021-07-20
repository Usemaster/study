package com.study.transformation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*
* 演示使用InputStreamReader转换流解决中文乱码问题
* 将字节流FileInputStream转成字符流InputStreamReader,指定编码gbk/utf-8
* */
public class InputStreamReader_ {

    public static void main(String[] args) throws Exception{

        String filePath = "e:\\note.txt";
        //1.将FileInputStream转换成InputStreamReader
        //2.指定编码 gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3.把InputStreamReader 传入 BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //将2和3合在一起
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
        //4.读取
        String s = br.readLine();
        System.out.println("读取内容=" + s );
        //5.关闭外层流
        br.close();
    }

}

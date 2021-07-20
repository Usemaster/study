package com.study.homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//读取一个文件内容并显示行号
public class Homework02 {

    public static void main(String[] args) throws IOException {
        String filePath = "e:\\story.txt";
        String len = null;
        int lineNum = 1;

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        while ((len = br.readLine())!=null){

            System.out.println(lineNum++ + " " + len);
        }

        br.close();


    }

}

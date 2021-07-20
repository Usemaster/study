package com.study.reader_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {

    public static void main(String[] args) {



    }

    /**
     * 单个字符读取文件
     */
    @Test
    public void readFile01(){
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int data = 0;

        try {
            //1.创建FileReader对象
            fileReader = new FileReader(filePath);
            //循环读取 使用read,单个字符读取
            while ((data = fileReader.read())!=-1){
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 字符数组读取文件
     */
    @Test
    public void readFile02(){
        String filePath = "e:\\story.txt";
        FileReader fileReader = null;
        int len = 0;
        char[] buffer = new char[8];
        try {
            //1.创建FileReader对象
            fileReader = new FileReader(filePath);
            //循环读取 使用read(buffer),返回的是实际读取到的字符数
            //返回-1，说明到文件的结束
            while ((len = fileReader.read(buffer))!=-1){
                System.out.print(new String(buffer,0,len));;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}

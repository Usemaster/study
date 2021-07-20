package com.study.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream01 {

    public static void main(String[] args) {

    }

    /*
    * 使用FileOutputStream将数据写到文件中
    * 如果该文件不存在，则创建该文件
    * */
    @Test
    public void writeFile(){

        //创建FileOutputStream对象
        String filePath = "e:\\a.txt";
        FileOutputStream fos = null;

        try {
            //new FileOutputStream(filePath)创建方式，当写入内容时，会覆盖原本的内容
            //new FileOutputStream(filePath,true)创建方式，当写入内容时，是追加内容
            fos = new FileOutputStream(filePath,true);
            //写入一个字符
//            fos.write('G');
            //写入字符串
            String str = "hello,world";
            //str.getBytes() 可以把 字符串 -> 字节数组
            //fos.write(str.getBytes());
            /*
            * 将指定字节数组中的len个字节从偏移量off开始写入此文件输出流。
                参数：
                b——数据。
                off – 数据中的起始偏移量。
                len – 要写入的字节数。
            * */
            fos.write(str.getBytes(),0,str.length());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

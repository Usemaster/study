package com.study.inputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;


//FileInputStream的使用（字节输入流 文件--> 程序）
public class FileInputStream_ {

    public static void main(String[] args) {

    }

    /*
    * 单个字节的读取，效率比较低
    * 改进使用read(byte[] b)
    * */
    @Test
    public void readFile01(){
        String filePath = "e:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取一个字节的数据。如果没有输入可用，此方法将阻止
            //如果返回-1，读取完毕
            while ((readData = fileInputStream.read())!=-1){
                System.out.print((char)readData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    * 使用read(byte[] b) 读取文件提高效率
    * */
    @Test
    public void readFile02(){
        String filePath = "e:\\hello.txt";
        //字节数组
        byte[] buffer = new byte[8];
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //创建FileInputStream对象用于读取文件
            fileInputStream = new FileInputStream(filePath);
            //从该输入流读取最多b.length字节的数据到字节数组。如果没有输入可用，此方法将阻止
            //如果返回-1，读取完毕
            //如果读取正常，返回实际读取的字节数
            while ((readLen = fileInputStream.read(buffer))!=-1){
                System.out.print(new String(buffer,0,readLen));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}

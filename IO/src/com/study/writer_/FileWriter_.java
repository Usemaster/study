package com.study.writer_;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_ {

    public static void main(String[] args) {

        String filePath = "e:\\note.txt";
        //创建FileWriter对象
        FileWriter fileWriter = null;
        char[] chars = {'a','b','c'};

        try {
            fileWriter = new FileWriter(filePath);
//          write(int):写入单个字符
            fileWriter.write('H');
//          write(char[]):写入指定数组
            fileWriter.write(chars);
//          write(char[],off,len):写入指定数组的指定部分
            fileWriter.write("韩顺平教育".toCharArray(),0,3);
//          write(string):写入整个字符串
            fileWriter.write(" 你好北京");
//          write(string,off,len):写入字符串的指定部分
            fileWriter.write("上海天津",0,2);
            //在数据量大的时候，可以使用循环操作

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //对于FileWriter，一定要关闭流，或者flush，才能真正的把数据写入到文件
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("程序结束");

    }


}

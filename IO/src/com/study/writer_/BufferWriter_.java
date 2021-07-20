package com.study.writer_;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

//演示BufferedWriter的使用
public class BufferWriter_ {

    public static void main(String[] args) throws Exception{

        String filePath = "e:\\hello.txt";
        //创建BufferedWriter对象
        //new FileWriter(filePath,true)以追加的方式写入
        //new FileWriter(filePath)以覆盖的方式写入
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath,true));

        bufferedWriter.write("hello,world");
        bufferedWriter.newLine();//插入一个和系统相关的换行
        bufferedWriter.write("hello2,world");
        bufferedWriter.newLine();
        bufferedWriter.write("hello3,world");

        //关闭流，这里注意，只需要关闭BufferedWriter（外层流），因为底层会自动的去关闭节点流
        bufferedWriter.close();

    }



}

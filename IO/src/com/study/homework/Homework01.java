package com.study.homework;

import java.io.*;

/*
(1)在判断e盘下是否有文件夹mytemp ,如果没有就创建mytemp
(2)在e:\\mytemp目录下,创建文件hello.txt
(3)如果hello.txt 已经存在，提示该文件已经存在,就不要再重复创建了
(4)并在hello.txt文件中写入hello,world
* */
public class Homework01 {

    public static void main(String[] args) throws IOException {
        String directoryPath = "e:\\mytemp";
        File file = new File(directoryPath);
        if (file.exists()){
            System.out.println("文件夹存在");
        }else {
            file.mkdir();
            System.out.println("文件夹创建成功");
        }

        String filePath = "e:\\mytemp\\hello.txt";
        File file1 = new File(filePath);
        if (file1.exists()){
            System.out.println("文件存在");
        }else {
            if (file1.createNewFile()){
                System.out.println(filePath+"创建成功");

                //如果文件存在，我们就使用BufferWriter字符输入流写入内容
                BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
                bw.write("hello world");
                bw.close();

            }else {
                System.out.println(filePath+"创建失败");
            }
        }




    }

}

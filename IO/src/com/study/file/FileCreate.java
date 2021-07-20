package com.study.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

//演示创建文件
public class FileCreate {

    public static void main(String[] args) {

    }

    @Test
    //方式1 new File(String pathname)  //根据路径构建一个File对象
    public void create01(){
        String filePath = "f:/news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    //方式2 new File(File parent,String child)  //根据父目录文件+子路径构建
    //f:\\news2.txt
    public void create02(){
        File parentFile = new File("f:/");
        String filename = "news2.txt";
        File file = new File(parentFile, filename);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    //方式3 new File(String parent,String child)  //根据父目录+子路径构建
    //f:\\news2.txt
    public void create03(){
        String parentPath = "f:/";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    

}

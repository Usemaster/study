package com.study.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class FileInformation {

    public static void main(String[] args) {



    }

    //获取文件信息
    @Test
    public void info(){
        //先创建文件对象
        File file = new File("D:\\图片\\1.png");

        //调用相应的方法，得到对应的信息
        System.out.println("文件名称=" + file.getName());
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件长度=" + file.length());
        System.out.println("文件是否存在=" + file.exists());
        System.out.println("是否是一个文件="  + file.isFile());
        System.out.println("是否是一个文件夹=" + file.isDirectory());
    }

}

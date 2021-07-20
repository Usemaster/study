package com.study.outputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件拷贝
public class FileCopy {

    public static void main(String[] args) {

        //1.创建文件的输入流，将文件读入到程序
        //2.创建文件的输出，将读取到的文件数据，写入到指定的文件

        String srcFilePath = "d:\\图片\\1.png";
        String destFilePath = "e:\\1.png";
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFilePath);
            fos = new FileOutputStream(destFilePath);
            //定义一个字节数组，提高读取效果
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer))!=-1){
                //读取到后，就写入到文件，通过FileOutputStream
                //即，边读边写
                fos.write(buffer,0,len);//一定要使用这个方法
            }
            System.out.println("拷贝成功");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                if (fis != null){
                    fis.close();
                }

                if (fos != null){
                    fos.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

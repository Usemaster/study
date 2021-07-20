package com.study.outputstream_;

import java.io.*;

//演示使用BufferedInputStream和BufferedOutputStream使用
//使用他们，可以完成二进制文件的拷贝
//字节流可以操作二进制文件，可以操作文本文件吗？当然可以
public class BufferedCopy02 {

    public static void main(String[] args) {
          //操作二进制文件
//        String srcFilePath = "e:\\1.png";
//        String destFilePath = "e:\\2.png";
        //操作文本文件
        String srcFilePath = "e:\\story.txt";
        String destFilePath = "e:\\story1.txt";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;


        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilePath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilePath));

            //循环读取文件，并写入到destFilePath
            byte[] buffer = new byte[1024];
            int len = 0;

            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bis != null){
                    bis.close();
                }

                if (bos != null){
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

}

package com.study.writer_;

import java.io.*;

public class BufferedCopy {

    public static void main(String[] args) {
        //BufferedReader 和 BufferedWriter是按照字符操作，不要去操作二进制文件,可能造成文件损坏

        String srcFilePath = "e:\\story.txt";
        String destFilePath = "f:\\story.txt";

        BufferedReader br = null;
        BufferedWriter bw = null;
        String line;

        try {
            br = new BufferedReader(new FileReader(srcFilePath));
            bw = new BufferedWriter(new FileWriter(destFilePath));

            //说明：readLine读取一行内容，但是没有换行
            while ((line = br.readLine()) != null){
                //每读取一行就写入
                bw.write(line);
                //换行
                bw.newLine();
            }
            System.out.println("拷贝完毕");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null){
                    br.close();
                }
                if (br != null){
                    bw.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}

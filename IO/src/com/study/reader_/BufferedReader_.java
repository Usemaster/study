package com.study.reader_;

import java.io.BufferedReader;
import java.io.FileReader;

//BufferedReader使用
public class BufferedReader_ {

    public static void main(String[] args) throws Exception{

        String filePath = "e:\\story.txt";
        //创建BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        //读取
        String line;//按行读取，效率高
        //bufferedReader.readLine()按行读取文件
        //当返回为null时，表示文件读取完毕
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }

        //关闭流，这里注意，只需要关闭BufferedReader（外层流），因为底层会自动的去关闭节点流
        //FileReader
        /*
            public void close() throws IOException {
                synchronized (lock) {
                    if (in == null)
                        return;
                    try {
                        in.close();//in 就是我们传入的new FileReader(filePath)，关闭了
                    } finally {
                        in = null;
                        cb = null;
                    }
                }
            }
        * */
        bufferedReader.close();


    }

}

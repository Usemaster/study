package com.study.properties_;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//传统方法后去配置文件
public class Properties01 {

    public static void main(String[] args) throws IOException {

        //读取mysql.properties文件，并得到ip、user和pwd
        BufferedReader br = new BufferedReader(new FileReader("src\\mysql.properties"));
        String line = "";
        while ((line = br.readLine()) != null){
//            System.out.println(line);
            String[] split = line.split("=");
            //如果我们要求获取指定的ip值
            if ("ip".equals(split[0])){
                System.out.println(split[0] + "值是" + split[1]);
            }
        }

        br.close();

    }

}

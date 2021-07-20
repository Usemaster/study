package com.study.properties_;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Properties03 {

    public static void main(String[] args) throws IOException {
        //使用Properties来创建配置文件，修改文件内容

        Properties properties = new Properties();
        //创建
        //setProperty如果没有k就创建有就修改
        properties.setProperty("charset","utf8");
        properties.setProperty("user","汤姆");//保存的是中文的unicode码
        properties.setProperty("pwd","888888");

        //将k-v存储到文件中即可
        properties.store(new FileOutputStream("src\\mysql2.properties"),"hello world");
        System.out.println("保存配置文件成功");
    }

}

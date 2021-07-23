package com.study.map_;

import java.io.PrintStream;
import java.util.Properties;

//Properties基本使用
public class Properties_ {

    public static void main(String[] args) {

        //增加
        //1.Properties 继承 Hashtable
        //2.可以通过k-v存放数据，当然key和value不能为空
        Properties properties = new Properties();
        properties.put("john",100);
        properties.put("lucy",100);
        properties.put("lic",100);
        properties.put("lic",88);//替换

        System.out.println("properties="+properties);

        //通过对应的key获取值
        System.out.println(properties.get("lic"));

        //删除元素
        properties.remove("lic");
        System.out.println("properties="+properties);

        //修改
        properties.put("john","约翰");
        System.out.println("properties="+properties);

    }

}

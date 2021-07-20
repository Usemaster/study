package com.study.inputstream_;

import com.study.outputstream_.Dog;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ObjectInputStream_ {

    public static void main(String[] args) throws Exception{

        //指定反序列化文件
        String filePath = "e:\\data.dat";

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));

        //读取（反序列化）的顺序需要和你保存数据（序列化）的顺序一致
        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readChar());
        System.out.println(ois.readDouble());
        System.out.println(ois.readUTF());
        Object dog = ois.readObject();
        System.out.println("运行类型=" + dog.getClass());
        System.out.println("dog信息=" + dog);//底层 Object -> Dog


        //如果我们希望调用Dog的方法,就需要向下转型
        //需要我们将Dog的定义，拷贝到可以引用的位置
        Dog dog1 = (Dog) dog;
        System.out.println(dog1.getName());

        //关闭流，关闭外层流即可
        ois.close();

    }

}

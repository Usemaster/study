package com.study.outputstream_;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//演示ObjectOutputStream的使用
public class ObjectOutputStream_ {

    public static void main(String[] args) throws Exception{
        //序列化后，保存的文件格式，不是存文本，而是按照它的格式保存
        String filePath = "e:\\data.dat";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));

        //序列化数据到e:\data.dat
        oos.writeInt(100);//int ->Integer (实现了Serializable)
        oos.writeBoolean(true);//boolean -> Boolean (实现了Serializable)
        oos.writeChar('a');//char -> Character(实现了Serializable)
        oos.writeDouble(9.7);//double -> Double(实现了Serializable)
        oos.writeUTF("你好世界");//String (实现了Serializable)
        //保存一个Dog对象
        oos.writeObject(new Dog("旺财",10));

        oos.close();
        System.out.println("数据保存完毕（序列化形式）");

    }

}


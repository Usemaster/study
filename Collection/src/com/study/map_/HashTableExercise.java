package com.study.map_;

import java.util.Hashtable;

public class HashTableExercise {

    public static void main(String[] args) {
        Hashtable table = new Hashtable();
        table.put("john",100);
        //table.put(null,100);//异常
        //table.put("john",null);//异常
        table.put("lucy",100);
        table.put("lic",100);
        table.put("lic",88);
        table.put("hello1",1);
        table.put("hello2",1);
        table.put("hello3",1);
        table.put("hello4",1);
        table.put("hello5",1);
        table.put("hello6",1);
        System.out.println(table);

        //简单说明一下Hashtable的底层
        //1.底层有数组 Hashtable$Entry[] 初始化大小为 11
        //2.临界值 threshold 8 = 11 * 0.75
        //3.扩容:按照自己的扩容机制来扩容
        //4.执行方法  addEntry(hash, key, value, index);添加K-V封装到Entry
        //5.当 if (count >= threshold)满足时，就进行扩容
        //按照    int newCapacity = (oldCapacity << 1) + 1;的大小扩容
    }

}

package com.study.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapSource_ {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put("no1","韩顺平");
        map.put("no2","张无忌");
        map.put(new Car(),new Person());

        //1.k-v最后是  HashMap$Node = newNode(hash, key, value, null)
        //2.k-v为了方便程序员的遍历，还会创建EntrySet集合，该集合存放的元素的类型Entry对象就有k,v EntrySet<Entry<K,V>>
        //即：    transient Set<Map.Entry<K,V>> entrySet;
        //3.entrySet中，定义的类型是Map.Entry，但是实际上存放的还是HashMap$Node
        //这是因为 HashMap$Node implements Map.Entry
        //4.当把HashMap$Node对象存放到entrySet就方便我们遍历,因为Map.Entry提供了两个重要方法
        //  K getKey(); V getValue();

        Set set = map.entrySet();
        System.out.println(set.getClass());//$EntrySet
        for (Object obj : set) {
//            System.out.println(obj.getClass());
            //为了从HashMap$Node取出k-v
            //1.先做一个向下转型
            Map.Entry entry = (Map.Entry) obj;
            System.out.println("key=" + entry.getKey() + "  value=" + entry.getValue());
        }


        Set set1 = map.keySet();
        System.out.println(set1.getClass());
        Collection values = map.values();
        System.out.println(values.getClass());

    }

}

class Car{

}

class Person{

}

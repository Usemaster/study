package com.study.map_;

import java.util.*;

//Map六大遍历方式
@SuppressWarnings({"all"})
public class MapFor {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋喆","马蓉");
        map.put("刘令博",null);
        map.put(null,"刘亦菲");
        map.put("鹿晗","关晓彤");

        //第一组：先取出所有的Key，通过Key取出对应的Value
        Set keyset = map.keySet();
        //(1)增强for
        System.out.println("-----第一种方式-----");
        for (Object key : keyset) {
            System.out.println(key+"-"+ map.get(key));
        }
        //(2)迭代器
        System.out.println("-----第二种方式-----");
        Iterator iterator = keyset.iterator();
        while (iterator.hasNext()){
            Object key = iterator.next();
            System.out.println(key+"-"+ map.get(key));
        }

        //第二组:把所有的values取出
        Collection values = map.values();
        //这里可以使用所有的Collection使用的遍历的方法
        //(1)增强for
        System.out.println("-----取出所有的value 增强for-----");
        for (Object value : values) {
            System.out.println(value);
        }
        //(2)迭代器
        System.out.println("-----取出所有的value 迭代器-----");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()) {
            Object value =  iterator1.next();
            System.out.println(value);
        }

        //第三组：通过EntrySet来获取k-v
        Set entrySet = map.entrySet();//EntrySet<Map.Entry<K,V>>
        //(1)增强for
        System.out.println("-----使用EntrySet的增强for(第三种)-----");
        for (Object entry : entrySet) {
            //将entry转成Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }

        System.out.println("-----使用EntrySet的迭代器(第四种)-----");
        Iterator iterator2 = entrySet.iterator();
        while (iterator2.hasNext()) {
            Object entry1 =  iterator2.next();
//            System.out.println(entry.getClass());//HashMap$Node 实现Map.Entry
            //向下转型 Map.Entry
            Map.Entry m1 = (Map.Entry) entry1;
            System.out.println(m1.getKey()+"-"+m1.getValue());
        }

    }

}

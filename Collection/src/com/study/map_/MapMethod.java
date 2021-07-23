package com.study.map_;

import java.util.HashMap;
import java.util.Map;

public class MapMethod {

    public static void main(String[] args) {

        //Map常用方法
        Map map = new HashMap();
        map.put("邓超",new Book("",100));
        map.put("邓超","孙俪");
        map.put("王宝强","马蓉");
        map.put("宋喆","马蓉");
        map.put("刘令博",null);
        map.put(null,"刘亦菲");
        map.put("鹿晗","关晓彤");
        map.put("hsp","hsp的老婆");

        System.out.println("map=" + map);
//
//      remove:根据键删除映射关系
        map.remove(null);
//      get:根据键获取值
        Object val = map.get("鹿晗");
        System.out.println(val);
//      size:获取元素个数
        System.out.println(map.size());
//      isEmpty:判断个数是否为0
        System.out.println(map.isEmpty());
//      clear:清除
        map.clear();
        System.out.println(map);
//      containsKey:查找键是否存在
        System.out.println(map.containsKey("hsp"));


    }

}

class Book{
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }

}

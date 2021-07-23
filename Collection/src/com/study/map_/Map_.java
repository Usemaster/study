package com.study.map_;

import java.util.HashMap;
import java.util.Map;

public class Map_ {

    public static void main(String[] args) {
        //接口实现类的特点
        Map map = new HashMap();
        map.put("no1","韩顺平");
        map.put("no2","张无忌");
        map.put("no1","张三丰");//当有相同的k，就等价于替换
        map.put("no3","张三丰");
        map.put(null,null);
        map.put(null,"abc");
        map.put("no4",null);
        map.put("no5",null);
        map.put(1,"赵敏");

        System.out.println(map.get("no3"));

        System.out.println("map="+map);
    }

}

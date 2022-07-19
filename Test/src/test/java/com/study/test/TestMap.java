package com.study.test;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

    //国家
    private static final Map map = new HashMap();

    //一级行政单位
    private static final Map map1 = new HashMap();

    //二级行政单位
    private static final Map map2 = new HashMap();

    //三级行政单位
    private static final Map map3 = new HashMap();

    //设置三级行政单位
    public void setMap3(String name){
        map2.put(map3,name);
    }

    //设置二级行政单位
    public void setMap2(String name){
        map1.put(map2,name);
    }

    //设置一级行政单位
    public void setMap1(String name){
        map.put(map1,name);
    }

}

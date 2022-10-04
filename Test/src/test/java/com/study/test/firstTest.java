package com.study.test;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.java.Log;
import org.junit.Test;

import java.util.*;

/**
 * @author gongwj
 * @Date 2022/9/12
 */
public class firstTest {

    @Test
    public  void mapTest(){
        Map<String, List<String>> mapList = new HashMap<>();
        Map<String, String> mapString = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        String s = "a#b#c#d";
        list.add("a#b#c#d");
        list1.add("a#b#c");
        mapList.put("1",list);
        mapList.put("1",list1);
        mapString.put("1",s);
        System.out.println(mapList);
        System.out.println(mapString);
        List<List<String>> list2 = new ArrayList<>();
    }

    @Test
    public void test(){
        try{
            String s = null;
            String[] split = s.split(",");
        }catch (RuntimeException e){
            System.out.println("catch里面");

        }
        System.out.println("测试");
    }

    @Test
    public void testFastJson(){
        JSONObject jsonObject = new JSONObject();
    }


}

package com.study.leetcode;

import javax.lang.model.element.VariableElement;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache01 {

    private int capacity;
    private Map<Integer,Integer> cache;

    public LRUCache01(int capacity){
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key){
        return cache.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        cache.put(key,value);
    }




}

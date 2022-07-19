package com.study.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

//用LinkedHashMap实现LRU
public class LRUCache extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    public int get(int key){
        return super.getOrDefault(key,-1);
    }

    public void put(int key,int value){
        super.put(key,value);
    }

    //如果此映射应删除其最旧的条目，则返回true
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

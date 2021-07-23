package com.study.list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {

    public static void main(String[] args) {
        /*
        * 1) void add(int index, Object ele):在index位置插入ele元素
        * 2) boolean addAll(int index,Collection eles):从index位置开始将eles中的所有元素添加进来
        * 3) Object get(int index):获取指定index位置的元素
        * 4) int indexOf(Object obj):返回obj在集合中首次出现的位置
        * 5) int lastlndexOf(Object obj):返回obj在当前集合中末次出现的位置
        * 6) Object remove(int index):移除指定index位置的元素，并返回此元素
        * 7) Object set(int index, Object ele):设置指定index位置的元素为ele ,相当于是替换.
        * 8) List subList(int fromIndex, int tolndex):返回从fromIndex到tolndex位置的子集合
        * */

        List list = new ArrayList();
        list.add("刘备");
        list.add("关羽");
        //在index=1的位置插入一个对象
        list.add(1,"张飞");
        System.out.println("list=" + list);

        List list2 = new ArrayList();
        list2.add("吕布");
        list2.add("曹操");
        list.addAll(1,list2);
        System.out.println("list="+ list);

        System.out.println(list.indexOf("曹操"));

        list.add("曹操");
        System.out.println("list="+ list);
        System.out.println(list.lastIndexOf("曹操"));

        list.remove(0);
        System.out.println("list="+ list);

        list.set(2, "刘备");
        System.out.println("list="+ list);

        //注意返回的子集合 fromIndex <= subList < toIndex
        List returnList = list.subList(0,2);
        System.out.println("returnList=" + returnList);
    }

}

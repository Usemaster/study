package com.study.set_;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//Set接口的常用方法
public class SetMethod {

    public static void main(String[] args) {

        //1.以Set接口的实现类HashSet来讲解Set接口的方法
        //2.Set接口的实现类的对象（Set接口对象），不能存放重复的元素
        //3.Set接口对象存放数据是无序(即添加顺序和取出顺序不一致)
        //4.取出的顺序是固定的
        Set set = new HashSet();

        set.add("john");
        set.add("lucy");
        set.add("john");
        set.add("jack");
        set.add(null);
        set.add(null);

        System.out.println("迭代器遍历");
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("增强for遍历");
        for (Object o : set) {
            System.out.println(o);
        }

        //Set接口对象，不能通过索引来获取



    }

}

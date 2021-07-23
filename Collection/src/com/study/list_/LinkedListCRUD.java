package com.study.list_;

import java.util.Iterator;
import java.util.LinkedList;

//LinkedList常用方法
public class LinkedListCRUD {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        //删除一个节点
        linkedList.remove();//这里默认删除第一个节点

        System.out.println("linkedList=" + linkedList);

        linkedList.set(1,999);


        System.out.println("====迭代器====");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("====增强for====");
        for (Object o : linkedList) {
            System.out.println(o);
        }


    }

}

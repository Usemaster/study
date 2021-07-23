package com.study.list_;

import java.util.*;

public class ListFor {

    public static void main(String[] args) {

        /*
        * 方式一：使用iterator
        * 方式二：使用增强for
        * 方式三：使用普通for
        * */

        //List接口的实现子类Vector、LinkedList
//        List list = new ArrayList();
//        List list = new Vector();
        List list = new LinkedList();
        list.add("刘备");
        list.add("关羽");
        list.add("张飞");
        list.add("黄忠");
        list.add("马超");

        Iterator it = list.iterator();

        System.out.println("===使用iterator===");

        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("===使用增强for===");
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("===使用普通for===");

        for (int i = 0; i < list.size(); i++) {
            Object o = list.get(i);
            System.out.println(o);
        }

    }

}

package com.study.collection_;

import java.util.ArrayList;
import java.util.Collection;

//增强for循环
public class CollectionFor {

    public static void main(String[] args) {

        Collection col = new ArrayList();

        col.add(new Book("三国演义","罗贯中",10.1));
        col.add(new Book("小李飞刀","古龙",5.1));
        col.add(new Book("红楼梦","曹雪芹",34.6));

        //使用增强for,在Collection中使用
        //增强for，底层仍然是迭代器
        for (Object book : col) {
            System.out.println("book=" + book);
        }

        System.out.println("==数组打印==");
        //增强for，也可以直接在数组使用
        int[] nums = {1,8,10,90};
        for (int num : nums) {
            System.out.println("num=" + num);
        }


    }

}

package com.study.list_;


import java.util.ArrayList;
import java.util.List;

//添加三本图书
//按价格排序，从低到高（使用冒泡排序）
public class ListExercise {

    public static void main(String[] args) {

        List list = new ArrayList();

        list.add(new Book("三国演义","罗贯中",10.1));
        list.add(new Book("小李飞刀","古龙",5.1));
        list.add(new Book("红楼梦","曹雪芹",34.6));
        list.add(new Book("西游记","吴承恩",10));


        //如何对集合排序

        for (Object o : list) {
            System.out.println(o);
        }

        //冒泡排序
        sort(list);
        System.out.println("==排序后==");
        for (Object o : list) {
            System.out.println(o);
        }

    }

    //静态方法
    //价格要求从小到大
    public static void sort(List list){

        int size = list.size();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j+1);
                if (book1.getPrice() > book2.getPrice()){
                    list.set(j,book2);
                    list.set(j+1,book1);
                }
            }
        }
    }

}

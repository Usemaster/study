package com.study.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Collection_ {
    //抑制所有警告
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //集合只要是两组（单列集合、双列集合）
        //Collection接口有两个重要的子接口List、Set，他们的实现子类都是单列集合
        //Map接口的实现子类是双列集合，存放k-v

        /*
        * 1) add:添加单个元素
        * 2) remove:删除指定元素
        * 3) contains:查找元素是否存在
        * 4) size:获取元素个数
        * 5) isEmpty:判断是否为空
        * 6) clear:清空
        * 7) addAll:添加多个元素
        * 8) containsAll:查找多个元素是否都存在
        * 9) removeAll:删除多个元素
        * 10)说明:以ArrayList实现类来演示.
        * */

        List list = new ArrayList();
        list.add("tom");
        list.add(10);
        list.add(true);
        System.out.println("list=" + list);
        list.remove(2);
        System.out.println("list=" + list);
        System.out.println(list.contains("tom"));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println("list=" + list);
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        list2.add("水浒传");
        list.addAll(list2);
        System.out.println("list=" + list);
        System.out.println(list.containsAll(list2));
        list.add("聊斋志异");
        System.out.println(list.removeAll(list2));
        System.out.println("list=" + list);


    }

}

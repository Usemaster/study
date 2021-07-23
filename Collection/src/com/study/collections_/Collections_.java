package com.study.collections_;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Collections_ {

    public static void main(String[] args) {

        //创建ArrayList用于测试
        ArrayList list = new ArrayList();
        list.add("tom");
        list.add("smith");
        list.add("king");
        list.add("milan");
        list.add("tom");

//        reverse(List):反转 List中元素的顺序
        Collections.reverse(list);
        System.out.println("list="+list);
//        shuffle(List):对List 集合元素进行随机排序
//        for (int i = 0; i < 5; i++) {
//            Collections.shuffle(list);
//            System.out.println("list="+list);
//        }
//        sort(List):根据元素的自然顺序对指定List集合元素按升序排序
        Collections.sort(list);
        System.out.println("自然排序后");
        System.out.println("list="+list);
//        sort(List, Comparator):根据指定的Comparator产生的顺序对List集合元素进行排序
        //按照字符串长度来排序
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        });
        System.out.println("按照字符串长度来排序");
        System.out.println("list="+list);
//        swap(List, int, int):将指定list集合中的i处元素和j处元素进行交换

        Collections.swap(list,2,3);
        System.out.println("list="+list);


//        Object max(Collection):根据元素的自然顺序，返回给定集合中的最大元素
        System.out.println("自然顺序最大元素="+ Collections.max(list));
//        Object max(Collection,Comparator):根据Comparator 指定的顺序,返回给定集合中的最大元素
        //返回长度最大的元素
        System.out.println("长度最大元素="+ Collections.max(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o1).length() - ((String)o2).length();
            }
        }));
//        Object min(Collection)
//        Object min(Collection, Comparator)
//        int frequency(Collection,Object):返回指定集合中指定元素的出现次数
        System.out.println("tom出现的次数=" + Collections.frequency(list,"tom"));
//        void copy(List dest,List src):将src中的内容复制到dest中
        ArrayList list1 = new ArrayList();
        //为了完成一个完整拷贝，我们需要献给list1赋值，大小和list.size()一样
        for (int i = 0; i < list.size(); i++) {
            list1.add("");
        }
        Collections.copy(list1,list);
        System.out.println("list1="+list1);
//        boolean replaceAll(List list, Object oldVal,Object newVal):使用新值替换List 对象的所有旧值
        System.out.println(Collections.replaceAll(list, "tom", "汤姆"));
        System.out.println("list="+list);

    }

}

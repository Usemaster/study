package com.study.set_;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet_ {

    public static void main(String[] args) {

        //1.当我们使用无参构造器，创建TreeSet时，仍然是无序的
        //2.添加的元素安装字符串大小来排序
        //3.使用TreeSet提供的一个构造器，可以传入一个比较器(匿名内部类)
        //并指定规则
        //4.简单看源码
        // 1)构造器把传入的比较器对象,赋给了TreeSet的底层TreeMap的属性this.comparator
        /*
              public TreeSet(Comparator<? super E> comparator) {
                this(new TreeMap<>(comparator));
              }
              public TreeMap(Comparator<? super K> comparator) {
                 this.comparator = comparator;
              }
            2)在调用treeSet.add("jack")，在底层会执行到
              Comparator<? super K> cpr = comparator;
              if (cpr != null) {//cpr就是我们的匿名内部类（对象）
                    do {
                        parent = t;
                        //动态绑定到我们的匿名内部类（对象）compare
                        cmp = cpr.compare(key, t.key);
                        if (cmp < 0)
                            t = t.left;
                        else if (cmp > 0)
                            t = t.right;
                        else //如果相等，即返回0，这个Key就没有加入
                            return t.setValue(value);
                    } while (t != null);
                }
        * */
//        TreeSet treeSet = new TreeSet();
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //下面调用String的compareTo方法进行字符串的大小比较
//                return ((String)o1).compareTo((String)o2);//从小到大
//                return ((String)o2).compareTo((String)o1);//从大到小
                //按照字符串长度大小比较
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        //添加数据
        treeSet.add("jack");
        treeSet.add("a");
        treeSet.add("hello");
        treeSet.add("work");
        treeSet.add("ceo");
        treeSet.add("abc");
//        treeSet.add("rose");

        System.out.println("treeSet="+treeSet);

    }

}

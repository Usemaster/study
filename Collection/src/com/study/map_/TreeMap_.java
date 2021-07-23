package com.study.map_;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMap_ {

    public static void main(String[] args) {

        //使用默认构造器是无序的

        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照传入的k(String)的大小进行排序
//                return ((String)o1).compareTo((String)o2);
                //按照传入的k(String)的长度大小排序
                return ((String) o1).length() - ((String) o2).length();
            }
        });
        treeMap.put("jack","eva");
        treeMap.put("tom","hello");
        treeMap.put("cd","hello");
        treeMap.put("a","world");//替换
        treeMap.put("hsp","hsp");//加入不了

        System.out.println("treeMap="+treeMap);

        /*
        * 源码解析
        * 1.构造器,把实现了Comparator接口的内名内部类（对象），传给TreeMap的comparator
             public TreeMap(Comparator<? super K> comparator) {
                this.comparator = comparator;
             }
          2.调用put方法
          2.1第一次添加,把k-v封装到Entry对象,放入root
           Entry<K,V> t = root;
           if (t == null) {
                compare(key, key); // type (and possibly null) check

                root = new Entry<>(key, value, null);
                size = 1;
                modCount++;
                return null;
            }
            2.2以后添加
            Comparator<? super K> cpr = comparator;
            if (cpr != null) {//遍历所有的key
                do {
                    parent = t;
                    cmp = cpr.compare(key, t.key);//动态绑定到我们的匿名内部类的compare
                    if (cmp < 0)
                        t = t.left;
                    else if (cmp > 0)
                        t = t.right;
                    else  //如果遍历过程中，发现准备添加的key和当前已有的key相等，就不添加
                        return t.setValue(value);
                } while (t != null);
            }
        * */

    }

}

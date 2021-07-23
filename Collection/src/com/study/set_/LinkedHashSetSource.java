package com.study.set_;


import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetSource {

    public static void main(String[] args) {

        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘",1001));
        set.add(123);
        set.add("HSP");

        System.out.println("set=" + set);
        //1.加入顺序和取出元素/数据的顺序一致
        //2.LinkedHashSet底层维护的是一个LinkedHashMap(是HashMap的子类)
        //3.LikedHashSet底层结构（数组和双向链表）
        //4.添加第一次时，直接将数组table扩容到16，存放的结点类型时LinkedHashMap$Entry
        //5.数组时HashMap$Node[] 存放的元素/数据是LinkedHashMap$Entry类型
        /*
            //继承关系是在内部类完成的
            static class Entry<K,V> extends HashMap.Node<K,V> {
                Entry<K,V> before, after;
                Entry(int hash, K key, V value, Node<K,V> next) {
                    super(hash, key, value, next);
                }
            }
        * */
    }

}
class Customer{
    private String name;
    private int no;

    public Customer(String name, int no) {
        this.name = name;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", no=" + no +
                '}';
    }
}

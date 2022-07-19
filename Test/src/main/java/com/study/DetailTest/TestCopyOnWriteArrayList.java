package com.study.DetailTest;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
除了add()外，ArrayList的其他写操作也可能抛出ConcurrentModificationException异常。
* */
public class TestCopyOnWriteArrayList {

    public static void main(String[] args) {
        /*
            java.util.ArrayList
            java.util.Arrays$ArrayList :该类中，并没有提供add()方法。如果调用add()，则会抛异常：UnsupportedOperationException
         */
        CopyOnWriteArrayList<String> names =  new   CopyOnWriteArrayList<String>();
//        ArrayList<String> names =  new ArrayList<>();
//        Vector<String> names = new Vector<>() ;//1.5
        names.add("zs") ;
        names.add("ls") ;
        names.add("ww") ;
        Iterator<String> iter = names.iterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());//仅仅对集合进行 读操作，不会有异常
            names.add("x");//仅仅对集合进行 写操作：因为ArrayList会动态扩容（1.5倍），因此names会无限扩大，因此会包
        }
    }

}

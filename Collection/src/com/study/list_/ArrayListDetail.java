package com.study.list_;

import java.util.ArrayList;

public class ArrayListDetail {

    public static void main(String[] args) {

        //ArrayList是线程不安全的，可以看源码，没有synchronized
        /*
        * public boolean add(E e) {
        *       ensureCapacityInternal(size + 1);  // Increments modCount!!
        *       elementData[size++] = e;
        *       return true;
        * }
        * */
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("jack");
        arrayList.add(null);
        System.out.println(arrayList);
    }

}

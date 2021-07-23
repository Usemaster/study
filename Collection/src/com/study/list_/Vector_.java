package com.study.list_;

import java.util.Vector;

public class Vector_ {

    public static void main(String[] args) {

        //无参构造器
        Vector vector = new Vector();
        //new Vector()底层
        /*
        * public Vector() {
        *   this(10);
        * }
        * */
        for (int i = 0; i < 10; i++) {
            /*
            *public synchronized boolean add(E e) {
            *   modCount++;
            *   ensureCapacityHelper(elementCount + 1);
            *   elementData[elementCount++] = e;
            *   return true;
            * }
            * */
            vector.add(i);
            /*确定是否需要扩容
            * private void ensureCapacityHelper(int minCapacity) {
            *   if (minCapacity - elementData.length > 0)
            *       grow(minCapacity);
            * }
            * */
        }

        /*如果数组大小不够用，就扩容，扩容算法
        int newCapacity = oldCapacity + ((capacityIncrement > 0) ?
                                        capacityIncrement : oldCapacity);
        就是扩容两倍
        * private void grow(int minCapacity) {
        *   int oldCapacity = elementData.length;
        *   int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
        *   if (newCapacity - minCapacity < 0)
        *       newCapacity = minCapacity;
        *   if (newCapacity - MAX_ARRAY_SIZE > 0)
        *       newCapacity = hugeCapacity(minCapacity);
        *   elementData = Arrays.copyOf(elementData, newCapacity);
        * }
        * */

        for (int i = 11; i < 20; i++) {
            vector.add(i);
        }

    }

}

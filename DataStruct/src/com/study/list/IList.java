package com.study.list;

/**
 *
 * @author Accper
 *
 */
public interface IList {
    // 线性表置空操作
    public void clear();

    // 判断线性表是否为空操作
    public boolean isEmpty();

    // 获取线性表中元素的长度操作
    public int length();

    // 获取指定位置上面的元素操作
    public Object get(int i);

    // 在指定位置上面插入元素的操作
    public void insert(int i, Object x);

    // 删除指定位置上面的元素的操作
    public void remove(int i);

    // 查找指定元素的位置首次出现的位置操作
    public int indexOf(Object x);

    // 显示线性表中的内容操作
    public void display();
}
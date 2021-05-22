package com.study.list;

/**
 *
 * @author Accper
 *
 */
public class SqList implements IList {
    // 线性表存储空间
    private Object[] listElem;
    // 线性表的当前长度
    private int curLen;

    // 顺序表类的构造函数，构造一个存储空间容量为maxSize的线性表
    public SqList(int maxSize) {
        // TODO Auto-generated constructor stub
        curLen = 0;
        listElem = new Object[maxSize];
    }

    // 将一个已经存在的线性表置成空表
    public void clear() {
        // TODO Auto-generated method stub
        // 置顺序表的当前长度为0
        curLen = 0;
    }

    // 判断线性表中的数据元素的个数是否为0，若为0则返回true，否则返回false
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return curLen == 0;
    }

    // 求线性表中的数据元素的个数并返回其值
    public int length() {
        // TODO Auto-generated method stub
        // 返回顺序表的当前长度
        return curLen;
    }

    // 读取到线性表中的第i个数据元素并由函数返回其值，其中i的取值范围为0≤i≤length()-1，若i不在此范围则抛出异常
    public Object get(int i) {
        // TODO Auto-generated method stub
        if (i < 0 || i >= curLen) {
            throw new RuntimeException("第" + i + "个元素不存在");
        }
        return listElem[i];
    }

    // 在线性表的第i个数据元素之前插入一个值位x的数据元素
    public void insert(int i, Object x) {
        // TODO Auto-generated method stub
        // 判断表是否满了
        if (curLen == listElem.length) {
            throw new RuntimeException("存储空间已经满了，无法插入新的元素");
        }
        // 插入的位置不合法
        if (i < 0 || i > curLen) {
            throw new RuntimeException("插入的位置不合法");
        }
        // 必须要从最后一个元素开始依次逐个后移动，直到第i个数据元素移动完毕为止。
        for (int j = curLen; j > i; j--) {
            listElem[j] = listElem[j - 1];
        }
        listElem[i] = x;
        curLen++;
    }

    public void remove(int i) {
        // TODO Auto-generated method stub
        if (i < 0 || i > curLen - 1) {
            throw new RuntimeException("删除的位置不合法");
        }
        for (int j = i; j < curLen; j++) {
            listElem[j] = listElem[j+1];
        }
        curLen--;
    }

    // 返回线性表中首次出现指定的数据元素的位序号，若线性表中不包含此数据元素，则返回-1
    public int indexOf(Object x) {
        // TODO Auto-generated method stub
        for (int i = 0; i < curLen; i++) {
            if (listElem[i].equals(x)) {
                return i;
            }
        }
        return -1;
    }

    // 输出线性表中的数据元素
    public void display() {
        // TODO Auto-generated method stub
        for (int i = 0; i < curLen; i++) {
            System.out.print(listElem[i] + " ");
        }
        System.out.println();
    }

    // 测试
    public static void main(String[] args) {
        SqList sqList = new SqList(10);
        sqList.insert(0, "a");
        sqList.insert(1, "z");
        sqList.insert(2, "d");
        sqList.insert(3, "m");
        sqList.insert(4, "z");
        int order = sqList.indexOf("z");
        if (order!=-1) {
            System.out.println("顺序表中第一次出现的值为z的数据元素的位置为："+order);
        }else {
            System.out.println("顺序表中不包括z元素");
        }
//        sqList.display();
    }
}

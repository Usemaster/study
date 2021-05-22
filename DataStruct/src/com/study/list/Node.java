package com.study.list;

/**
 *
 * @author Accper
 *
 */
public class Node {
    // 存放结点的值
    private Object data;
    // 后继结点的引用
    private Node next;

    // 无参数时的构造函数
    public Node() {
        // TODO Auto-generated constructor stub
        this(null, null);
    }

    // 带有一个参数时的构造函数
    public Node(Object data) {
        this(data, null);
    }

    // 带有两个参数时的构造函数
    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
package com.study.list_;

public class LinkedList01 {

    public static void main(String[] args) {
        //模拟一个简单的双向链表

        Node jack = new Node("jack");
        Node tom = new Node("tom");
        Node lisha = new Node("lisha");

        //连接三个节点
        jack.next = tom;
        tom.next = lisha;
        lisha.pre = tom;
        tom.pre = jack;

        Node first = jack;//头节点
        Node last = lisha;//尾节点

        //遍历
        System.out.println("===从头到尾进行遍历===");
        while (true){
            if (first == null){
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;
        }

        System.out.println("===从尾到头===");
        while (true){
            if (last == null){
                break;
            }
            System.out.println(last);
            last = last.pre;
        }

        //插入对象
        Node zf = new Node("zf");
        tom.next = zf;
        lisha.pre = zf;
        zf.pre = tom;
        zf.next = lisha;

        //让first再次指向第一个
        first = jack;
        System.out.println("===插入数据后打印===");
        while (true){
            if (first == null){
                break;
            }
            //输出first信息
            System.out.println(first);
            first = first.next;
        }


    }

}
//定义一个Node类，Node对象表示一个双向链表的节点
class Node{
    public Object item;//真正存放数据
    public Node next;//指向下一个节点
    public Node pre;//指向上一个节点
    public Node(Object name){
        this.item = name;
    }

    @Override
    public String toString() {
        return "Node name=" + item;
    }
}

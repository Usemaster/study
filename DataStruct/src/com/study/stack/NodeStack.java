package com.study.stack;


import java.util.Stack;

public class NodeStack<T> {
    private Node<T> top = null;
    public NodeStack(){
        this.top = null;
    }
    //判断栈是否为空
    public boolean isNull(){
        if(top == null){
            return true;
        }
        return false;
    }
    //压栈
    public boolean push(T data){
        Node<T> node = new Node<T>(data);
        node.setNext(top);
        top = node;
        return true;
    }
    //出栈
    public T pop(){
        if(isNull()){
            return null;
        }
        T tmp = top.data;
        top = top.getNext();
        return tmp;

    }
    //取出栈顶的值
    public T peek(){
        if(isNull()){
            return null;
        }
        return top.data;
    }
    class Node<T>{
        private T data;
        private Node<T> next;
        public Node(T value){
            this.data = value;
        }
        public Node<T> getNext(){
            return this.next;
        }
        public void setNext(Node<T> n){
            this.next = n;
        }
        public T getData(){
            return this.data;
        }
        public void setData(T d){
            this.data = d;
        }
    }

    public static void main(String args[]){
        NodeStack<String> ns = new NodeStack<String>();

        //测试是否为空
        System.out.println(ns.isNull());
        //压栈测试
        ns.push("asdwqewqewqea");
        ns.push("ewewwqsdsadsd");
        ns.push("ffddsfsdfdfdf");
        //测试是否为空
        System.out.println(ns.isNull());
        //出栈测试
        System.out.println(ns.pop());
        System.out.println(ns.pop());
        System.out.println(ns.pop());
        //测试是否为空
        System.out.println(ns.isNull());
    }



}

package com.study.algorithm;

import java.util.Stack;

public class Demo2 {

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.top());
        System.out.println(stack.getMAX());
    }
}
class MaxStack{
    //stack1存数据
    Stack<Integer> stack1;
    //stack2比较大小
    Stack<Integer> stack2;

    //初始化
    MaxStack(){
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void push(int x){
        stack1.push(x);
    }

    public int pop(){
        if (stack1 != null){
            stack1.pop();
        }
        return -1;
    }

    public int top(){
        if (stack1 != null){
           return stack1.peek();
        }
        return -1;
    }

    public int getMAX(){
        int res = -1;
        //当stack2为空，stack1不为空时进行大小比较
        while (stack2 == null){
            if (stack1 != null){
                //stack2存入一个数据，stack1的数据和stack2的数据进行比较，求出最大值
                stack2.push(stack1.pop());
                if (stack1.peek() > stack2.peek()){
                    stack2.pop();
                    stack2.push(stack1.pop());
                    res = stack2.peek();
                    return res;
                }
            }
        }
        return res;
    }
}

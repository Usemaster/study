package com.study.stack;


public class ArrayStack<T> {
    private T data[];
    private int maxSize;
    private int top;
    //初始化栈
    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        data = (T[]) new Object[maxSize];
        this.top = -1;
    }
    //判断栈是否已空
    public boolean isNull(){
        if(top == -1){
            return true;
        }
        return false;
    }
    //判断栈是否已满
    public boolean isFull(){
        if(top == maxSize-1){
            return true;
        }
        return false;
    }
    //将value压栈
    public boolean push(T value){
        if(isFull()){
            return false;
        }
        top++;
        data[top] = value;
        return true;
    }
    //取出栈顶元素
    public T pop(){
        if(isNull()){
            return null;
        }
        T tmp = data[top];
        data[top] = null;
        top--;
        return tmp;
    }
    public static void main(String args[]){
        ArrayStack<String> as = new ArrayStack<String>(4);
        as.push("sasa");
        as.push("qwwq");
        as.push("erer");
        as.push("ddsd");
        //测试栈已满时的情况
        System.out.println(as.push("hhhhh"));
        //测试出栈顺序
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());
        System.out.println(as.pop());

    }

}


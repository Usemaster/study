package com.study.nowcoder;

//代码初始化顺序
public class D
{
    public static D t1 = new D();
    public static D t2 = new D();
    {
        System.out.println("构造块");
    }
    static
    {
        System.out.println("静态块");
    }
    public static void main(String[] args)
    {
        D t = new D();//构造块 构造块 静态块 构造块
    }
}

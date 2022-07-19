package com.study.nowcoder;

//值传递和引用传递
//Java中只有值传递
//值传递是将变量的一个副本传递到方法中，方法中如何操作该变量副本，都不会改变原变量的值。
//引用传递是将变量的内存地址传递给方法，方法操作变量时会找到保存在该地址的变量，对其进行操作。会对原变量造成影响。
class Value{
    public int i=15;
}
public class ValueTest{
    public static void main(String argv[]){
        ValueTest t = new ValueTest( );
        t.first( );
    }

    public void first( ){
        int i=5;
        Value v=new Value( );
        v.i=25;
        second(v,i);
        System.out.println(v.i);//20
    }

    public void second(Value v,int i){
        i = 0;
        v.i = 20;
        Value val = new Value( );
        v = val;//i = 15
        System.out.println(v.i+" "+i);//15 0
    }
}


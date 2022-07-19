package com.study.nowcoder;

public class ZeroTest {
    public static void main(String[] args) {
        try{
            int i = 100 / 0;//会抛出异常，不执行System.out.print(i);代码
            System.out.print(i);
        }catch(Exception e){
            System.out.print(1);
            throw new RuntimeException();//会抛出异常只会执行finally中的代码，其他地方的代码都不会执行
        }finally{
            System.out.print(2);
        }
        System.out.print(3);
    }
}

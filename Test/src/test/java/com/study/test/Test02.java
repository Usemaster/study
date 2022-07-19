package com.study.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test02 {

    @Test
    public void test01(){
        int x=3;
        int y=1;
        //x=y是赋值操作，值为int类型，不能用于判断
//        if(x=y)
//            System.out.println("Not equal");
//        else
//            System.out.println("Equal");
    }

    @Test
    public void test02(){
        int x = -5;
        int y = -12;
        System.out.println(y % x);
    }

    @Test
    public void test03(){
        System.out.println(14 ^ 3);
    }

    @Test
    public void test04(){
        System.out.println(824 % 64);
        System.out.println(0 % 2);
    }

    static int arr[] = new int[5];

    @Test
    public void test05(){
        String s = "0123456789";
        System.out.println(s.substring(5));
        System.out.println(s.substring(0,5));
        System.out.println(arr[0]);
        long test = 012;
        float f = -142;
        double d = 0x12345678;
    }

    @Test
    public void test06(){
        char myChar = 'g';
        String myStr = Character.toString(myChar);
        System.out.println("String is: "+myStr);
        myStr = String.valueOf(myChar);
        System.out.println("String is: "+myStr);
    }

    @Test
    public void test07(){
        float[][] f = new float[6][];
    }

    @Test
    public void test08(){
        System.out.println(Math.abs(-10 / -2));
        System.out.println(divide(-2147483648, -1));
    }

    @Test
    public void test09(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void  test10(){
        int i = 5;
        int j = 10;
        System.out.println(i + ~j);

        System.out.println(2014 % 9);
    }

    @Test
    public  void test11(){
        try {
            int i = 1 / 0;
            throw new ArithmeticException();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    @Test
    public  void  test12(){
        //取模运算，余数的符号跟被除数符号相同
        System.out.println(-10 % 3);//-1
        Map<Integer,Integer> map = new HashMap<>();
        map.getOrDefault(1,0);
    }

    @Test
    public void test13(){
        int m,n;
        //Required type:boolean
        //Provided:int
        //for (m = 0, n = -1; n = 0; m++, n++)
        //n++;
    }

    public int divide(int dividend, int divisor) {
        if(dividend < 0 && divisor < 0){
            return Math.abs(dividend / divisor);
        }
        return dividend / divisor;
    }

    public String solve(String s, String t) {
        int a = Integer.parseInt(s);
        int b = Integer.parseInt(t);
        int sum = a + b;
        return String.valueOf(a + b);
    }
}

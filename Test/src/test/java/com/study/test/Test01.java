package com.study.test;

import org.junit.Test;

import javax.swing.plaf.PanelUI;
import java.util.*;

public class Test01 {

    @Test
    public void test01(){
        String s1 = "hello";
        String s2 = new String("hello");
        String s3 = new String("hello");
        System.out.println(s1 == s2);//false
        System.out.println(s2 == s3);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s2.equals(s3));//true
        System.out.println(s1.equals(s3));//true

    }

    @Test
    public void test02(){
        List list = new ArrayList();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.add(0,4);
        list.remove(1);
        for (Object o : list) {
            System.out.println(o);
        }
    }
    @Test
    public void test03(){
        Boolean flag = false;
        if(flag = true){
            System.out.println("true");
        }else{

            System.out.println("false");
        }
    }

    @Test
    public void test04(){
        mystery(1234);
    }

    @Test
    public void test05(){
        int i = -5;
//        i =  ++(i++);
        System.out.println(i);
    }

    @Test
    public void test06(){
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    @Test
    public void test07(){
        HelloA helloA = new HelloA();
    }
    @Test
    public void test08(){
//        byte b1=1,b2=2,b3,b6,b8;
//        final byte b4=4,b5=6,b7;
//        b3=(b1+b2);  /*语句1*/
//        b6=b4+b5;    /*语句2*/
//        b8=(b1+b4);  /*语句3*/
//        b7=(b2+b5);  /*语句4*/
//        System.out.println(b3+b6);
    }

    @Test
    public void test09(){
        System.out.println(-5 + 1/4 + 2*-3 + 5.0);
    }

    @Test
    public void test10(){
        int i=0;
        Integer j = new Integer(0);
        System.out.println(i==j);
        System.out.println(j.equals(i));
    }

    @Test
    public void test11(){
        String a = new String("myString");
        String b = "myString";
        String c = "my" + "String";
        String d = c;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
        System.out.println(b == d);
    }

    @Test
    public void test12(){
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        //equals比较的是两个数组的地址
        System.out.println(arr1.equals(arr2));//false
        //Arrays.equals比较两个数组的内容
        System.out.println(Arrays.equals(arr1, arr2));//true

        System.out.println(arr1 == arr2);//false
    }

    @Test
    public void  test13(){
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('b');
        set.add('c');
        set.remove('b');
        for (Character character : set) {
            System.out.println(character);
        }
    }




    public static void mystery (int x)
    {
        System.out.print(x % 10);

        if ((x / 10) != 0)
        {
            mystery(x / 10);
        }
        System.out.print(x % 10);
    }




}
class HelloA {
    public HelloA() {
        System.out.println("A的构造函数");
    }
    {
        System.out.println("A的构造代码块");
    }
    static {
        System.out.println("A的静态代码块");
    }
    public static void main(String[] args) {
        HelloA a = new HelloA();
    }
}

class SendValue{
    public String str="6";
    public static void main(String[] args) {
        SendValue sv=new SendValue();
        sv.change(sv.str);
        System.out.println(sv.str);
    }
    public void change(String str) {
        str="10";
    }
}


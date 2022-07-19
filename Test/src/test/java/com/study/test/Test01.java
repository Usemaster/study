package com.study.test;

import org.junit.Test;
import sun.reflect.generics.tree.VoidDescriptor;

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

    @Test
    public void test14(){
        int a = Integer.parseInt("1024");

        int b = Integer.valueOf("1024").intValue();

        System.out.println(a == b);
    }

    @Test
    public void test15(){
        System.out.println(7/-3);
    }

    @Test
    public void test16(){
        String str = "";
        System.out.print(str.split(",").length);
        double d1=-0.5;
        System.out.println("Ceil d1="+Math.ceil(d1));
        System.out.println("floor d1="+Math.floor(d1));
    }

    @Test
    public void test17(){
        String s = "祝你考出好成绩！";
        System.out.println(s.length());
    }

    @Test
    public void test18(){
        String s;
//        System.out.println(s);
    }

    @Test
    public void test19(){
        System.out.println(12 % 2);
    }


    @Test
    public void test20(){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 2){
                    continue;
//                    break;
                }
                System.out.println(j);
            }
        }
    }
    @Test
    public void test21(){
        System.out.println(Math.round(11.5));
        System.out.println(Math.round(-11.5));
    }

    @Test
    public void test22(){
        System.out.println(5 & 1);
        System.out.println(5 ^ 5 ^ 3);
    }

    @Test
    public void test23(){
        System.out.println(1 / 2);
        System.out.println(1 % 2);
        System.out.println(0 % 2);
    }

    @Test
    public void test24(){
        List  Listlist1 = new ArrayList();
        Listlist1.add(0);
        List Listlist2 = Listlist1;
        System.out.println(Listlist1.get(0) instanceof Integer);
        System.out.println(Listlist2.get(0) instanceof Integer);
    }


    @Test
    public void test25(){
        double d = 5.3e12;
        System.out.println(d);
    }

    @Test
    public void test26(){
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);

    }

    @Test
    public void test27(){
//        int a [10];
//        int a [];
//        int a[] = new int[10];
//        int a [] = {1,2,3,4,5};
        int x = 1;
        float y = 2;
        System.out.println(x / y);
    }

    @Test
    public void test28(){
        Integer a = new Integer(46);
        Integer b = new Integer(46);
        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    @Test
    public void test29(){
        System.out.println(45 % 3);
    }

    @Test
    public void  test30(){
        Example example = new Example();
        example.run();
        System.out.println("main");
    }

    @Test
    public void test31(){
        String str = "";
        System.out.println(str.split(",").length);
    }

    @Test
    public void test32(){
//        System.out.println(AccountType.FIXED);
        System.out.println(Math.floor(-8.5));
        float f = 3;
        System.out.println(f);
    }

    enum AccountType{
        SAVING,FIXED,CURRENT;
        private AccountType(){
            System.out.println("It is a account type");
        }
    }

    public class Example extends Thread{
        public void run(){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("run");
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


package com.study.test01;

import java.util.*;

public class Test02 {

    public static boolean isAdmin(String userId){
        return userId.toLowerCase() == "admin";
    }

//    public int aMethod(){
//        static int i = 0;
//        i++;
//        return i;
//    }\

   private static int i = 0;
    private String word = " ";
    public void setWord(String word){
        this.word = word;
    }
    public void setI(int i){
        Test02.i = i;
    }

    public static void main(String[] args) throws InterruptedException {

//        int[][] arr = {{1,1,1},{1,2,2},{1,3,2},{2,1}};
//        System.out.println(Arrays.deepToString(arr));
//        System.out.println(arr[3][1]);
//        System.out.println(8/3*3);
//        System.out.println(1 / 3);
////        System.out.println(5 / 3);
//        int i = 1;
//        i = i++;
//        int j = i++;
//        int k = i + ++i * i++;
//        System.out.println("i="+i);
//        System.out.println("j="+j);
//        System.out.println("k="+k);
//        Object o = 'f';
//        char s = '\u0639';
//        int i = 1000;
//        String s = "hello,world\0";
//        System.out.println(isAdmin("Admin"));
//        System.out.println(3 % 5);
//        try {
//            int i = 100 / 0;
//            System.out.println(i);
//        }catch (Exception e){
//            System.out.println(1);
//            throw new RuntimeException();
//        }finally {
//            System.out.println(2);
//        }
//        System.out.println(3);
//        List<Integer> score = new ArrayList<>();
//        int temp;
//        score.forEach(i -> temp = i < temp ? i : temp);
//        String s = null;
//        s.concat("abc");
//        int[] a = new int[5];
//        System.out.println(17^5);
//        Integer d1 = new Integer(2017);
//        Integer d2 = 2017;
//        System.out.println(d1 == d2);
//        UUID uuid = UUID.randomUUID();
//        System.out.println(uuid);
//        float f=42.0f;
//        float f1[]=new float[2];
//        float f2[]=new float[2];
//        float[] f3=f1;
//        long x=42;
//        f1[0]=42.0f;
//        System.out.println(x == f1[0]);
//        String str = "hello world";
//        str = str+100;
//        Runnable runner = new Runnable(){
//            @Override
//            public void run() {
//                System.out.print("foo");
//            }
//        };
//        Thread t = new Thread(runner);
//        t.run();
//        System.out.println("bar");
//        Integer i01=59;
//        int i02=59;
//        Integer i03=Integer.valueOf(59);
//        Integer i04=new Integer(59);
//        System.out.println(i02 == i04);
//        System.out.println(i03 == i04);
//        Thread thread1 = new Thread(()->{
//            System.out.println(Thread.currentThread().getName() + "Thread1");
//        });
//
//        Thread thread2 = new Thread(()->{
//            System.out.println(Thread.currentThread().getName() + "Thread2");
//        });
//
//        thread1.start();
//        String s = "祝你考出好成绩！";
//        System.out.println(s.length());
//        System.out.println(i);
//        byte b1=1,b2=2,b3,b6;
//        final byte b4=4,b5=6;
//        b6=b4+b5;
//        b3=(b1+b2);
//        System.out.println(b3+b6);
//        String str1="hello";
//
//        String str2="he"+ new String("llo");
//
//        System.out.println(str1==str2);
//        Object o=new Object(){
//            public boolean equals(Object obj){
//                return true;
//            }
//        };
//        System.out.println(o.equals("Fred"));
//        List<Integer> list = new ArrayList<>();
//        list.add(5);
//        list.add(3);
//        list.add(1);
//        list.add(6);
//        //add(int index, E element)在此列表中的指定位置插入指定元素。
//        //将当前在该位置的元素(如果有)和任何后续元素向右移动(向它们的索引添加一个)
//        list.add(0,4);
//        list.remove(1);
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//        //错误
////        int a [11] = new int[11];
//        //父类引用指向子类引用 多态
//        Object x = new String("Hellow");
        Test02 test02 = new Test02();
        test02.setWord("123");
        test02.setI(2);


    }

}

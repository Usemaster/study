package com.study.nowcoder;

public class People {

    String name;

    public People(){
        System.out.println(1);
    }

    public People(String name){
        System.out.println(2);
        this.name = name;
    }

    public static void main(String[] args) {
        //子类初始化会先调用父类的无参构造，子类重写父类的方法调用子类的方法
        //new Child("mike");//1 3 2
        System.out.println(test1());//20 45
    }

    public static int test1(){
        int a = 20;
        try {
            //a的值没变
            return a + 25;
        } catch (Exception e) {
            System.out.println("test catch exception");
        } finally {
            //打印a = 20
            System.out.println(a + " ");
            a = a + 10;
        }
        return a;
    }

}

class Child extends People{

    People father;

    public Child(String name){
        System.out.println(3);
        this.name = name;
        //调用父类的有参构造
        father = new People(name + ":F");
    }

    public Child(){
        System.out.println(4);
    }

}

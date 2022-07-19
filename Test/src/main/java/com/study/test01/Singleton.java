package com.study.test01;

/*
* 单例模式:双重校验锁(DCL懒汉式)
* */
public class Singleton {

    //要用volatile修饰，因为
    private static volatile Singleton instance = null;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }

}

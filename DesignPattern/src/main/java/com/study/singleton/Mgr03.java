package com.study.singleton;

/*
* 懒汉式 使用时实例化 多线程下不安全
* 当一个对象要实例化完成时，另一个对象也实例化并完成，导致两个实例化对象不一样
* */
public class Mgr03 {

    private static Mgr03 INSTANCE;

    private Mgr03(){
    }

    public static Mgr03 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Mgr03.getInstance().hashCode())
            ).start();
        }

    }

}

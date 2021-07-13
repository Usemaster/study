package com.study.singleton;

/*
*静态内部类方式
* JVM保证单例
* 加载外部类时不会立即加载内部类，只有调用方法时才会装载，而且只会装载一次。这样就可以实现懒加载
* */
public class Mgr07 {

    private Mgr07(){
    }

    private static class Mgr07Holder{
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->
                    System.out.println(Mgr07.getInstance().hashCode())
            ).start();
        }

    }

}

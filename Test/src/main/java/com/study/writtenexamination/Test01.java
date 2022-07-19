package com.study.writtenexamination;

public class Test01 {

    public volatile int inc = 0;

    public void  increase(){
        inc++;
    }

    public static void main(String[] args) {
        final Test01 test01 = new Test01();
        for (int i = 0; i < 10; i++) {
            new Thread(){
                public void run(){
                    for (int j = 0; j < 1000; j++)
                        test01.increase();
                };
            }.start();
        }
        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(test01.inc);
    }

}

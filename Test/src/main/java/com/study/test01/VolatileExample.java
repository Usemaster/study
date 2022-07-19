package com.study.test01;

public class VolatileExample {

    volatile long v1 = 0L;

    public void set(Long l){
        v1 = l;
    }

    public void getAndIncrement(){
        v1++;
    }

    public long get(){
        return v1;
    }

    public static void main(String[] args) {
        VolatileExample volatileExample = new VolatileExample();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                volatileExample.getAndIncrement();
                System.out.println("第"+Thread.currentThread().getName()+"个线程:"+volatileExample.get());
            },String.valueOf(i)).start();
        }
    }

}

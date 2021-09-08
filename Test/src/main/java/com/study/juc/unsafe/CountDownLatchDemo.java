package com.study.juc.unsafe;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown();//计数-1
            },String.valueOf(i)).start();
        }
        //等待计数器归零，然后向下执行
        countDownLatch.await();
        System.out.println("关门");
    }

}

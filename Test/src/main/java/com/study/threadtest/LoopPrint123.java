package com.study.threadtest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
线程交替打印
建立三个线程，第一个线程打印1，第二个线程打印2，第三个线程打印3，要求3个线程交替打印
* */
public class LoopPrint123 {

    //初始值
    private int number = 1;

    private Lock lock = new ReentrantLock();

    //通知打印1的信号
    private Condition con1 = lock.newCondition();
    //通知打印2的信号
    private Condition con2 = lock.newCondition();

    //通知打印3的信号
    private Condition con3 = lock.newCondition();


    public void print1(){
        lock.lock();

        try {
            //如果number是1就打印，不是就等待
            if (number != 1){
                con1.await();
            }
            System.out.println(1);
            //打印完1之后，去唤醒打印2的线程
            number = 2;
            con2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print2(){
        lock.lock();

        try {
            //如果number是2就打印，不是就等待
            if (number != 2){
                con2.await();
            }
            System.out.println(2);
            //打印完2之后，去唤醒打印3的线程
            number = 3;
            con3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print3(){
        lock.lock();

        try {
            //如果number是3就打印，不是就等待
            if (number != 3){
                con3.await();
            }
            System.out.println(3);
            //打印完3之后，去唤醒打印1的线程
            number = 1;
            con1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        LoopPrint123 loopPrint = new LoopPrint123();

        new Thread(() ->{
            while (true){
                loopPrint.print1();
            }
        }).start();

        new Thread(() ->{
            while (true){
                loopPrint.print2();
            }
        }).start();

        new Thread(() ->{
            while (true){
                loopPrint.print3();
            }
        }).start();
    }

}

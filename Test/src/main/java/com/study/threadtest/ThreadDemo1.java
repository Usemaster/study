package com.study.threadtest;

public class ThreadDemo1 implements Runnable{

    private int tickets = 100;

    @Override
    public void run() {
        while (true){
            sellTickets();
        }
    }

    public synchronized void sellTickets() {
        if(tickets > 0){
            System.out.println(Thread.currentThread().getName() + tickets);
            tickets--;
        }
    }

    public static void main(String[] args) {
        ThreadDemo1 t = new ThreadDemo1();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.setName("t1售货点");
        t2.setName("t2售货点");

        t1.start();
        t2.start();
    }
}

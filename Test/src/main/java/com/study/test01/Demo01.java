package com.study.test01;

public class Demo01 {

    private String content;

    public void setContent(){
        this.content = content;
    }

    public String getContent(){
        return content;
    }

//    public static void main(String[] args) {
//        Demo01 demo01 = new Demo01();
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//        for (int i = 0; i < 5; i++) {
//            new Thread(()->{
//                threadLocal.set(Thread.currentThread().getName() + "的数据");
//                System.out.println(Thread.currentThread().getName() + "\t " + threadLocal.get());
//            },String.valueOf(i)).start();
//        }
//    }

    public static void main(String args[])throws InterruptedException{
        Thread t=new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("2");
            }
        });
        t.start();

        t.join();
        System.out.print("1");
    }

}

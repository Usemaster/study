package com.demo.ch04;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class TestPriorityBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<MyJob> priority = new PriorityBlockingQueue<MyJob>();
        priority.add(new MyJob(3));
        priority.add(new MyJob(2));
        priority.add(new MyJob(1));
        System.out.println("队列: " + priority);

        //注意：优先级的排序规则，会在第一次调用take()方法之后才生效

        System.out.println("取出队列中的一个元素" + priority.take().getId());
        System.out.println("容器:" + priority);
    }

}

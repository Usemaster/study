package com.demo.com.usemaster.oom;/**
 * @author gongwj
 * @Date 2022/1/12
 */

/**
 * @author gongwj
 * @Date 2022/1/12
 */
/**
 * vm参数：-Xss2M
 * JDK使用的HotSpot虚拟机的栈内存大小是固定的，我们可以把栈的内存设大一点，然后不断地去创建线程，因为操作系统给每个进程分配的内存是有限的，所以到最后，也会发生OutOfMemoryError异常。
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread() {
        while (true) {
//            Thread thread = new Thread(new Runnable() {
//                public void run() {
//                    dontStop();
//                }
//            });
            Thread thread = new Thread(()->{dontStop();});
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}

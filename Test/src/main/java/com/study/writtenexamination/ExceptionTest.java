package com.study.writtenexamination;

public class ExceptionTest {

    public static void main(String[] args) {
        try {
            int a = 100;
            int b = 0;
            //100 % 0 ArithmeticException: / by zero
            //不能除以0会会直接抛出异常，不会执行下面的代码
            int c = 100 % b;
            System.out.println("step1");
            int d = a / b;
            System.out.println("step2");
        } catch (RuntimeException e) {
            System.out.println("exception1");
        } catch (Exception e){
            System.out.println("exception2");
        }

    }

}

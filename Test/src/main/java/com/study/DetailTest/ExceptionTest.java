package com.study.DetailTest;

public class ExceptionTest {

    public static void main(String[] args) {
        //run
        //java.lang.RuntimeException: Error
        try {
            System.out.println("run");
            throw  new RuntimeException("Error");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //run
            //finally
            //java.lang.RuntimeException: Error
            System.out.println("finally");
        }
    }

}

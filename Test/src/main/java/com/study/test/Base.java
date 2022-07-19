package com.study.test;

public class Base {
    void  test() throws Exception{
        try {
            System.out.println("try");
            throw new Exception();
        }catch (Exception e){
            System.out.println("catch exception");
        }finally {
            System.out.println("finally");
        }
        return;
    }

    public static void main(String[] args) {
        Base obj = new Base();
        try {
            obj.test();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

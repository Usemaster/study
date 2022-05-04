package com.study.test01;

public class Demo01 {

    public static void main(String[] args) {
        int a = 5;
        System.out.println(testReturn(a));
    }

    public static boolean testReturn(int a){
        for (int i = 0; i < 10; i++) {
            if(a < i){
                return true;
            }
        }
        return false;
    }

}

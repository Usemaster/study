package com.study.test;

public class Recursion {

    public static void main(String[] args) {
        System.out.println(f(6));
    }

    public static int f(int x){
        if (x < 2){
            return x;
        }
        return f(x-1)+f(x - 2);
    }

}

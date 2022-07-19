package com.study.test01;

public class Demo04 {

    public static void main(String[] args) {
        int a = 5;
        Demo04 demo04 = new Demo04();
        demo04.testReturn(a);
//        System.out.println(demo04.testReturn(5));
    }

    public boolean testReturn(int a){
        for (int i = 0; i < 10; i++) {
            if(a > i){
                return true;
            }
        }
        return false;
    }

}

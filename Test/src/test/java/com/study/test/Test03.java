package com.study.test;

public class Test03 {

    public static void main(String[] args) {

        lableA:
        for (int i = 0; i < 10; i++) {
            lableB:
            for (int j = 0; j < 10; j++) {
                    if (j == 3){
                        System.out.print(i + "");
                        System.out.println(j);
                        break lableB;
                    }
            }
        }

    }

}

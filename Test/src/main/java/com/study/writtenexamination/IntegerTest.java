package com.study.writtenexamination;

public class IntegerTest {

    public static void main(String[] args) {
        boolean result1 = Integer.valueOf(127) == new Integer(127);
        boolean result2 = Integer.valueOf(127) == 127;
        boolean result3 = Integer.valueOf(127) == Integer.valueOf(127);
        boolean result4 = new Integer(127) == new Integer(127);

        //false、true、true、false
        System.out.println(result1 + "、" + result2 + "、" + result3 + "、" + result4);
    }

}

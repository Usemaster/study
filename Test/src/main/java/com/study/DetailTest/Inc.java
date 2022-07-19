package com.study.DetailTest;

public class Inc {



    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;
        inc.fermin(i);
        //i = i++等同于
        //i=i++;等同于：
        //temp=i； (等号右边的i)
        //i=i+1;      (等号右边的i)
        //i=temp;   (等号左边的i)
        //而i=++i;则等同于：
        //i=i+1;
        //temp=i;
        //i=temp;
        i = i ++;
        System.out.println(i);

    }
    void fermin(int i){
        i++;
    }

}

package com.study.writtenexamination;

import java.util.Scanner;

//给定一个字符串，由字符a-z组成，求这个字符串中连续子串（所谓连续子串，是指a-z按照顺序出现的子串，例如abc，bcd是连续子串，而bce不是）一共有多少个。
public class CountString {

    public static void main(String[] args){
        System.out.println("请输入字符串");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(countString(s));
    }

    public static int countString(String s){
        int len = s.length() - 1;
        //计算连续子串的长度
        int count = 1;
        //计算连续子串的个数
        int res = 0;
        for(int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++) {
                if(s.charAt(i + 1) > s.charAt(i)){
                    count++;
                    if(count % 3 == 0){
                        res++;
                        count = 1;
                    }
                }
            }
        }
        return res;
    }

}

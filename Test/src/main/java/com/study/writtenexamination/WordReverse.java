package com.study.writtenexamination;

import java.util.Scanner;

/*
途家民俗
题目描述：
对一段由英文单词、标点符号和空格组成的段落，按照单词逆序输出段落，不丢失任何字符。 输入样例： When you were born,you were crying and everyone around you was smiling.Live your life so that when you die,you're the one who is smiling and everyone around you is crying. 输出结果：

.crying is you around everyone and smilling is who one the you're,die you when that so life your Live.smiling was you around everyone and crying were you,born were you When
* */
public class WordReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        int len = s.length() - 1;
        int right = len;
        int left = len;
        for (int i = len; i >= 0; i--) {
            if('A' < s.charAt(i) && s.charAt(i) < 'z'){
                left--;
            }else{
                sb.append(s.charAt(i));
                sb.append(s.substring(left,right));
                right = left;
            }
        }
        System.out.println(sb.toString());
    }

}

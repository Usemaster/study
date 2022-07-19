package com.study.leetcode;

public class StringTest {

    public static void main(String[] args) {
        String shortname = "abf";
        String fullname = "abcde";
        System.out.println(isContain(shortname, fullname));
    }

    public static boolean isContain (String shortname, String fullname) {
        // write code here
        int sLen = shortname.length();
        int fLen = fullname.length();
        int i = 0,j = 0;
        while (i < sLen && j < fLen){
            if (shortname.charAt(i) == fullname.charAt(j)){
                i++;
            }
            j++;
        }
        if (i == sLen){
            return true;
        }
        return false;
    }



}

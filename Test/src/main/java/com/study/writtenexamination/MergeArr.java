package com.study.writtenexamination;

import java.util.Arrays;
import java.util.Scanner;

//有两个有序数组，合并为一个有序数组。
//
// 示例：
//
// 输入：
//
//arrayA : [1， 3， 5， 7， 9]
//
//arrayB : [2, 4, 6, 8, 10]
//
// 输出：
//
//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
//
//提示：请在本地将代码调通后再提交
public class MergeArr {


    public static void main(String[] args) {
        System.out.println("请输入字符串");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(s);
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};

        System.out.println(Arrays.toString(mergeArray(a, b)));
        System.out.println(Arrays.toString(mergeArray1(a, b)));
    }

    //双指针
    public static int[] mergeArray(int[] a,int[] b){
        int m = a.length;
        int n = b.length;
        int[] res = new int[m + n];
        int i = 0,j = 0;
        int cur = 0;
        while(i < m || j < n){
            if(i == m){
                cur = b[j++];
            }else if(j == n){
                cur = a[i++];
            }else if(a[i] < b[j]){
                cur = a[i++];
            }else{
                cur = b[j++];
            }
            res[i + j - 1] = cur;
        }
        return res;
    }

    public static int[] mergeArray1(int[] a,int[] b){
        int m = a.length;
        int n = b.length;
        int[] res = new int[m + n];
        for (int i = 0; i < m; i++){
            res[i] = a[i];
        }
        for(int i = 0; i < n; ++i){
            res[m + i] = b[i];
        }
        Arrays.sort(res);
        return res;
    }

}

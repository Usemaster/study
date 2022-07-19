package com.study.algorithm;


import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        int[] arr = {165,176,158,160,180,173,175,166,169,183};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] height){
        int low = 0;
        for (int i = 0;i < height.length;i++){

        }
        return height;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

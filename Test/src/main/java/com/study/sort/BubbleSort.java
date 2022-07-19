package com.study.sort;

import java.util.Arrays;

@SuppressWarnings({"all"})
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {5,3,6,8,1,7,9,4,2};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }

    public static int[] bubbleSort(int[] arr){
        int length = arr.length-1;//长度-1防止j+1越界
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

}

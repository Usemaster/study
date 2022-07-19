package com.study.sort;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        int[] array = {5,3,6,8,1,7,9,4,2};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    public static int[] selectSort(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[min] > arr[j]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }
}

package com.study.test;

import java.util.Arrays;

//冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {24,69,80,57,13};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){
        int length = array.length-1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

}

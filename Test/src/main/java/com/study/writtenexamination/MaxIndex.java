package com.study.writtenexamination;

//给定一个整形数组由2段组成，每一段都是升序的，且前面一段所有元素大于后面一段所有元素，找到第2段起始点的下标。
//举例：input = a[17,29,56,3,9,11]，那么应该输出3的下标
public class MaxIndex {

    public static void main(String[] args) {
        int[] arr = {17,29,56,3,9,11};
        System.out.println(getIndex(arr));
    }

    public static int getIndex(int[] arr){
        int len = arr.length;
        int index = 0;
        int max = arr[0];
        for (int i = 1; i < len; i++) {
            if(arr[i] > max){
                max = arr[i];
                index = i;
            }
        }
        return index+1;
    }
}

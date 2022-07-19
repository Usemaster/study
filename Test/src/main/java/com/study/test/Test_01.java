package com.study.test;

public class Test_01 {
    public int minNumber(int[] arr){
        int n = arr.length;
        for(int i= 0;i<n;i++){
            while(arr[i] >= 1 && arr[i] <= n && arr[arr[i] -1] != arr[i]){
                swap(arr,arr[i]-1,i);
            }
        }
        for(int i=0;i<n;i++){
            if(arr[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[j];
        arr[i] = arr[j];
        arr[j] = arr[i];
    }

    public static void main(String[] args) {
        int [] arr = {-1,2,-3,4};
        Test_01 test_01 = new Test_01();
        System.out.println(test_01.minNumber(arr));
    }
}

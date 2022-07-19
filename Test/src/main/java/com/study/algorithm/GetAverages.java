package com.study.algorithm;

import java.util.Arrays;

public class GetAverages {

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        System.out.println(Arrays.toString(getAverages(nums, k)));
    }

    public static int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        if(len == 1 && k == 0){
            return new int[]{nums[0]};
        }
        if(len == 1 && k > nums.length){
            return new int[]{-1};
        }
        int[] res = new int[len];
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(i < k){
                res[i] = -1;
            }else if(i + k < len){
                for(int j = (i - k); j <= (i + k); j++){
                    sum += nums[j];
                }
                System.out.println(sum);
                sum /= 7;
                res[i] = sum;
                sum = 0;
            }else{
                res[i] = -1;
            }
        }
        return res;
    }

}

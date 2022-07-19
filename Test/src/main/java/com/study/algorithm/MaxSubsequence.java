package com.study.algorithm;

import java.util.Arrays;

public class MaxSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,3};
        int k = 2;
        System.out.println(Arrays.toString(maxSubsequence(nums, 2)));
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        Arrays.sort(nums);
        int[] res = new int[k];
        int j = 0;
        for(int i = nums.length - 1; i >=nums.length - k; i--){
            res[j] = nums[i];
            j++;
        }
        return res;
    }

}

package com.study.leetcode;

public class SmallestEqual {


    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        System.out.println(smallestEqual(nums));
    }

    public static int smallestEqual(int[] nums) {
        int len = nums.length;
        int index = -1;
        for(int i = 0; i < len; i++){
            if(nums[i] == i % 10){
                index = i;
                return index;
            }
        }
        return index;
    }

}

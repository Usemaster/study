package com.study;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;



public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[8];
        nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
//        for (int i = 0; i < 8; i++) {
//            System.out.println(nums[i]);
//        }
        TwoSum twoSum = new TwoSum();
        twoSum.twoSum(nums,8);
    }

    //暴力解法
//    public int[] twoSum(int[] nums,int target){
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map=new HashMap<>();//元素值和元素位置的映射
//        map.put(nums[0], 0);
//        for(int i=1;i<nums.length;i++) {
//            int matchedNum=target-nums[i];//nums[i]和matchedNum的索引即为所求
//            if(map.containsKey(matchedNum)) {//map存储过matchedNum的映射
//                int index1=i;
//                int index2=map.get(matchedNum);
//                System.out.print("["+index1+ "," + index2 + "]");
//                return new int[] {index1,index2};
//            }else//map未存储过
//                map.put(nums[i], i);
//        }
//        return null;
//    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");

    }

}

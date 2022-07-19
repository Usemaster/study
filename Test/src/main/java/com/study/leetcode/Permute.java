package com.study.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//46.全排列
public class Permute {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> permute = permute(nums);
        for (List<Integer> list : permute) {
            for (Integer integer : list) {
                System.out.print(integer);
            }
            System.out.println();
        }
    }

    static List<List<Integer>> res = new LinkedList<>();

    public static List<List<Integer>> permute(int[] nums) {
        //记录路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }


    public static void backtrack(int[] nums,LinkedList<Integer> track){
        //结束条件 nums中的元素全部在track中出现
        if(track.size() == nums.length){
            res.add(new LinkedList(track));
            return;
        }

        for(int i = 0; i < nums.length; i ++){
            //排除不合法的选择
            if(!track.contains(nums[i])){
                //做选择
                track.add(nums[i]);
                //进入下一层决策树
                backtrack(nums,track);
                //取消选择
                track.removeLast();
            }
        }
    }

}

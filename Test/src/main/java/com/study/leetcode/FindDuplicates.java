package com.study.leetcode;/**
 * @author gongwj
 * @Date 2022/5/8
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author gongwj
 * @Date 2022/5/8
 */
public class FindDuplicates {

    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int count  = 0;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,count)+1);
        }

        for (int num : nums) {
            if(map.get(num) ==2){
                res.add(num);
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

}

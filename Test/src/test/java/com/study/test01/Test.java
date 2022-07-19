package com.study.test01;

import java.util.*;

public class Test {

    private class A{
        public void process(){
            System.out.println("A");
        }
    }

    private class B extends A{
        public void process() throws  RuntimeException{
            super.process();
            if(true){
                throw new RuntimeException();
            }
            System.out.println("B");
        }
    }

    private void test(){
        try {
            ((A)new B()).process();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(args));
    }

    int matrix[][];

    @org.junit.Test
    public void test01(){
//        Random random = new Random();
//        for (int i = 0; i < 50; i++) {
//            int ran = random.nextInt(10);
//            System.out.println(ran);
//        }
//        matrix = new int[1][1];
        System.out.println(32 / 7);
        System.out.println(1 % 10);
        String word = "abcdef";



    }

    public int sumOfUnique(int[] nums) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        for (Integer num : map.keySet()) {
            if(map.get(num) == 1){
                res+=num;
            }
        }
        return res;
    }

    @org.junit.Test
    public void test02(){
        String a = "aaa";
        String b = "aaa";
        int res = -1;

        if(a.contains(b)){
            System.out.println(res);
        }else{
            res = Math.max(a.length(),b.length());
            System.out.println(res);
        }

    }

    @org.junit.Test
    public void test03(){
        String[] strs = new String[]{"abc", "bce", "cae","cde"};
        int row = strs.length;
        int col = strs[0].length();
        System.out.println(row);
        System.out.println(col);
    }

    @org.junit.Test
    public void test04(){
        List<String> list = new ArrayList<>();
        list.add("测试企业 测试标签1");
        list.add("测试企业2 测试标签2");
        list.add("测试企业3 测试标签3");
        List<String> result = new ArrayList<>();
        for (String s : list) {
            if(s.contains("企业")){
                result.add(s);
            }
        }
//        int[] ints = null;
//        System.out.println(ints.length);
        System.out.println(result);

    }

    @org.junit.Test
    public void test05(){
        List<String> list = new ArrayList<>();
        list.add("测试企业 测试标签1");
        list.add("测试企业2 测试标签2");
        list.add("测试企业3 测试标签3");
        for (String s : list) {
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i++) {
                list.add(s1[i]);
            }
        }
        System.out.println(list);
    }

}

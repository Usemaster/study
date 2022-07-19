package com.study.writtenexamination;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//ACM模式，自定义输入输出
public class Main {

    public static void main(String[] args) {

        //单个输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入鸡的数量");
        int n = sc.nextInt();

        //数组输入
//        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入数组元素");
        int[] chickens = new int[n];
        for(int i = 0;i < n; i++){
//            chickens[i] = sc1.nextInt();
            chickens[i] = sc.nextInt();
        }
        for(int i =0; i < n; i++){
            System.out.println(chickens[i]);
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(map.containsKey(chickens[i])){
                map.put(chickens[i],map.getOrDefault(chickens[i],0) + 1);
            }
            map.put(chickens[i],1);
        }



    }

}

package com.study.lambda;

import com.study.DetailTest.Inc;

import javax.lang.model.element.VariableElement;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class LambdaTest {


    public static void main(String[] args) {
        String[] res = {"aaaa","bbbb","cccc"};
        List<String> list = Arrays.asList(res);

        //Java7
        for (String s : list) {
            System.out.println(s);
        }

        //Java8
        //Lambda表达式的写法之一
        //双冒号（::）运算符在Java 8中被用作方法引用（method reference），方法引用是与lambda表达式相关的一个重要特性。
        list.forEach(System.out::println);

    }

}

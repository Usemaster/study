package com.demo.com.usemaster.stream;/**
 * @author gongwj
 * @Date 2022/1/4
 */

import com.demo.com.usemaster.lambda.Employee;
import com.study.DetailTest.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author gongwj
 * @Date 2022/1/4
 */
public class StreamApi {

    protected List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99, Employee.Status.SLEEPING),
            new Employee("李四", 38, 5555.55, Employee.Status.WORKING),
            new Employee("王五", 60, 6666.66, Employee.Status.WORKING),
            new Employee("赵六", 8, 7777.77, Employee.Status.SLEEPING),
            new Employee("田七", 58, 3333.33, Employee.Status.VOCATION)
    );

    //通过Stream流实现集合的去重
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        List<String> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test01(){
        //过滤
        Stream<Employee> stream = employees.stream().filter((e)->{
            System.out.println("StreamAPI中间操作");
            return e.getAge() > 30;
        });
        //外部迭代
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println("------------------------------------------");

        Iterator<Employee> iter = employees.stream().filter((e) -> {
//            System.out.println("StreamAPI中间操作");
            return e.getAge() > 30;
        }).iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }

        System.out.println("------------------------------------------");

        //limit()方法主要作用为：截断流，使其元素不超过给定数量。
        employees.stream().filter((e)-> e.getAge() > 30).limit(2).forEach(System.out::println);

        //skip()方法跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素 不足 n 个，则返回一个空流。与limit(n) 互补。
        System.out.println("------------------------------------------");
        employees.stream().filter((e)-> e.getAge() > 30).skip(2).forEach(System.out::println);

        //distinct()方法筛选，通过流所生成元素的 hashCode() 和 equals() 去 除重复元素。
        //这里有一个需要注意的地方：distinct 需要实体中重写 hashCode（）和 equals（）方法才可以使用。
        System.out.println("------------------------------------------");
        employees.stream().distinct().forEach(System.out::println);

        //collect(Collector c)将流转换为其他形式。接收一个 Collector 接口的实现，用于给 Stream中元素做汇总的方法。
        //将流中每一个元素都映射到 map 的函数中，每个元素执行这个函数，再返回
        System.out.println("------------------------------------------");
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream().map((e) -> e.toUpperCase()).forEach(System.out::printf);
        //获取 Employee 中的每一个人得名字 name，再返回一个集合
        List<String> names = this.employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println();
        //自然排序
//        List<Employee> persons = employees.stream().sorted().collect(Collectors.toList());
        //定制排序
        System.out.println("------------------------------------------");
        List<Employee> persons1 = employees.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return 0;
            } else if (e1.getAge() > e2.getAge()) {
                return 1;
            } else {
                return -1;
            }
        }).collect(Collectors.toList());
        persons1.stream().forEach(System.out::println);
    }

    @Test
    public void test02(){
        //allMatch()方法表示检查是否匹配所有元素。
        //注意：使用 allMatch()方法时，只有所有的元素都匹配条件时，allMatch()方法才会返回 true。
        boolean match = employees.stream().allMatch((e) -> Employee.Status.SLEEPING.equals(e.getStatus()));
        System.out.println(match);
    }
    
    @Test
    public void test03(){
        System.out.println(0.9 < 1);
    }





}


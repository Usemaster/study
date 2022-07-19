package com.study.DetailTest;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.function.*;

/*
Lambda表达式格式：
方法的参数列表->方法体
只包含一个抽象方法的接口称为函数式接口
函数式接口
    消费型接口：有参数，无返回值
    供给型接口：无参数，有返回值
    函数型接口：有参数，有返回值
    断言型接口：有参数，返回值是boolean
方法引用
    1.类名：：静态方法名
    2.对象名：：非静态方法
    3.类名：：非静态方法
    4.构造器引用
    5.数组引用
* */
public class Lambda {

    public static void main(String[] args) {

        //Lambda表达式风格一
        Predicate<Integer> p = num->num<10;

        //Lambda表达式风格二
        //将Lambda表达式所代表的函数式接口对象，作为一个方法的传入参数
        //String upperStr = upper((str)->str.toUpperCase(),"hello world");
        new Thread(()-> System.out.println("hello world"),String.valueOf(1)).start();

        //方法引用形式一：“类名：：静态方法名”
        BiFunction<Integer,Integer,Integer> bf = Math::max;
        int result = bf.apply(20,10);
        System.out.println(result);

        //方法引用形式二：“对象名：：非静态方法名”
        ArrayList<String> list = new ArrayList<>();
        //Lambda形式
        //Predicate<String> predicate = (x)->list.add(x);
        //方法引用形式
        Predicate<String> predicate = list::add;

        Consumer<String> con = System.out::println;

        //方法引用形式三：类名::非静态方法
        //Lambda表达式形式
        //BiPredicate<String,String> bp = (a,b)->a.equals(b);
        BiPredicate<String,String> bp = String::equals;

        //方法引用形式四：构造器引用 类名::new
//        Supplier<Person> s = Person::new;

        //方法引用形式五：数组引用 元素类型[] :: new
        //Function<Integer,String[]> fun = num -> new String[num];
        Function<Integer,String[]> fun = String[]::new;
    }

}

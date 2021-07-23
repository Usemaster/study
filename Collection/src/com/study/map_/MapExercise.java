package com.study.map_;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
* 使用HashMap添加3个员工对象,要求键:
员工id
值:员工对象
并遍历显示工资>18000的员工(遍历方式最少两种)员工类:姓名工资、员工id
* */
public class MapExercise {

    public static void main(String[] args) {

        Map map = new HashMap();
        map.put(1,new Employee("jack",300000,1));
        map.put(2,new Employee("jack",21000,2));
        map.put(3,new Employee("milan",12000,3));

        //遍历2种方式
        //1.使用keySet -> 增强for
        Set keySet = map.keySet();
        for (Object key : keySet) {
            Employee emp = (Employee) map.get(key);
            if (emp.getSal() > 18000){
                System.out.println(emp);
            }
        }
        //2.EntrySet -> 迭代器
        System.out.println("---EntrySet -> 迭代器---");
        Set entrySet = map.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Object entry =  iterator.next();
            Map.Entry m = (Map.Entry) entry;
            Employee emp1 = (Employee) m.getValue();
            if (emp1.getSal()>18000){
                System.out.println(emp1);
            }

        }
    }

}

class Employee{
    private String name;
    private double sal;
    private int id;

    public Employee(String name, double sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", id=" + id +
                '}';
    }
}
